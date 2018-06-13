/*******************************************************************************
 * Copyright (c) 2017 Chen Chao and other ECD project contributors.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.sf.feeling.decompiler.fernflower;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FilenameFilter;
import java.io.PrintStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jetbrains.java.decompiler.main.decompiler.ConsoleDecompiler;
import org.jetbrains.java.decompiler.main.decompiler.PrintStreamLogger;
import org.jetbrains.java.decompiler.main.extern.IFernflowerLogger;
import org.jetbrains.java.decompiler.main.extern.IFernflowerPreferences;
import org.sf.feeling.decompiler.JavaDecompilerPlugin;
import org.sf.feeling.decompiler.editor.DecompilerType;
import org.sf.feeling.decompiler.editor.IDecompiler;
import org.sf.feeling.decompiler.util.ClassUtil;
import org.sf.feeling.decompiler.util.FileUtil;
import org.sf.feeling.decompiler.util.JarClassExtractor;
import org.sf.feeling.decompiler.util.UnicodeUtil;

public class FernFlowerDecompiler implements IDecompiler
{

	private String source = ""; // $NON-NLS-1$ //$NON-NLS-1$
	private long time, start;
	private String log = ""; //$NON-NLS-1$
	
	ByteArrayOutputStream loggerStream;

	/**
	 * Performs a <code>Runtime.exec()</code> on jad executable with selected
	 * options.
	 * 
	 * @see IDecompiler#decompile(String, String, String)
	 */
	@Override
	public void decompile( String root, String packege, final String className )
	{
		if ( root == null || packege == null || className == null )
			return;

		start = System.currentTimeMillis( );
		log = ""; //$NON-NLS-1$
		source = ""; //$NON-NLS-1$

		loggerStream = new ByteArrayOutputStream( );
		
		File workingDir = new File( root + "/" + packege ); //$NON-NLS-1$

		final Map<String, Object> mapOptions = new HashMap<String, Object>( );

		mapOptions.put( IFernflowerPreferences.REMOVE_SYNTHETIC, "1" ); //$NON-NLS-1$
		mapOptions.put( IFernflowerPreferences.DECOMPILE_GENERIC_SIGNATURES, "1" ); //$NON-NLS-1$
		mapOptions.put( IFernflowerPreferences.DECOMPILE_INNER, "1" ); //$NON-NLS-1$
		mapOptions.put( IFernflowerPreferences.DECOMPILE_ENUM, "1" ); //$NON-NLS-1$
		mapOptions.put( IFernflowerPreferences.LOG_LEVEL, IFernflowerLogger.Severity.ERROR.name( ) );
		mapOptions.put( IFernflowerPreferences.ASCII_STRING_CHARACTERS, "1" ); //$NON-NLS-1$
		if ( ClassUtil.isDebug( ) )
		{
			mapOptions.put( IFernflowerPreferences.DUMP_ORIGINAL_LINES, "1" ); //$NON-NLS-1$
			mapOptions.put( IFernflowerPreferences.BYTECODE_SOURCE_MAPPING, "1" ); //$NON-NLS-1$
		}

		final File tmpDir = new File( System.getProperty( "java.io.tmpdir" ), //$NON-NLS-1$
				String.valueOf( System.currentTimeMillis( ) ) );

		if ( !tmpDir.exists( ) )
			tmpDir.mkdirs( );

		// Work around protected constructor
		class EmbeddedConsoleDecompiler extends ConsoleDecompiler {

			protected EmbeddedConsoleDecompiler()
			{
				super( tmpDir, 
					   mapOptions , 
					   new PrintStreamLogger(new PrintStream( loggerStream )));
			}
			
		}
		ConsoleDecompiler decompiler = new EmbeddedConsoleDecompiler();
		
		File[] files = workingDir.listFiles( new FilenameFilter( ) {

			@Override
			public boolean accept( File dir, String name )
			{
				if ( name.toLowerCase( ).indexOf( className.toLowerCase( ) ) != -1 )
					return true;
				return false;
			}
		} );
		if ( files != null )
		{
			for ( int j = 0; j < files.length; j++ )
			{
				decompiler.addSource( files[j] );
			}
		}

		decompiler.decompileContext( );

		File classFile = new File( tmpDir, className.replaceAll( "(?i)\\.class", ".java" ) ); //$NON-NLS-1$ //$NON-NLS-2$

		source = UnicodeUtil.decode( FileUtil.getContent( classFile ) );

		classFile.delete( );

		FileUtil.deltree( tmpDir );

		Pattern wp = Pattern.compile( "/\\*.+?\\*/", Pattern.DOTALL ); //$NON-NLS-1$
		Matcher m = wp.matcher( source );
		while ( m.find( ) )
		{
			if ( m.group( ).matches( "/\\*\\s*\\d*\\s*\\*/" ) ) //$NON-NLS-1$
				continue;
			String group = m.group( );
			group = group.replace( "/*", "" ); //$NON-NLS-1$ //$NON-NLS-2$
			group = group.replace( "*/", "" ); //$NON-NLS-1$ //$NON-NLS-2$
			group = group.replace( "*", "" ); //$NON-NLS-1$ //$NON-NLS-2$
			if ( log.length( ) > 0 )
				log += "\n"; //$NON-NLS-1$
			log += group;

			source = source.replace( m.group( ), "" ); //$NON-NLS-1$
		}

		time = System.currentTimeMillis( ) - start;
	}

	/**
	 * Jad doesn't support decompilation from archives. This methods extracts
	 * request class file from the specified archive into temp directory and
	 * then calls <code>decompile</code>.
	 * 
	 * @see IDecompiler#decompileFromArchive(String, String, String)
	 */
	@Override
	public void decompileFromArchive( String archivePath, String packege, String className )
	{
		start = System.currentTimeMillis( );
		File workingDir = new File(
				JavaDecompilerPlugin.getDefault( ).getPreferenceStore( ).getString( JavaDecompilerPlugin.TEMP_DIR )
						+ "/" //$NON-NLS-1$
						+ System.currentTimeMillis( ) );

		try
		{
			workingDir.mkdirs( );
			JarClassExtractor.extract( archivePath, packege, className, true, workingDir.getAbsolutePath( ) );
			decompile( workingDir.getAbsolutePath( ), "", className ); //$NON-NLS-1$
		}
		catch ( Exception e )
		{
			JavaDecompilerPlugin.logError( e, e.getMessage( ) );
			return;
		}
		finally
		{
			FileUtil.deltree( workingDir );
		}
	}

	@Override
	public long getDecompilationTime( )
	{
		return time;
	}

	@Override
	public List getExceptions( )
	{
		return Collections.EMPTY_LIST;
	}

	/**
	 * @see IDecompiler#getLog()
	 */
	@Override
	public String getLog( )
	{
		if (loggerStream != null) {
			return log + loggerStream.toString( );
		}
		return log;
	}

	/**
	 * @see IDecompiler#getSource()
	 */
	@Override
	public String getSource( )
	{
		return source;
	}

	@Override
	public String getDecompilerType( )
	{
		return DecompilerType.FernFlower;
	}

	@Override
	public String removeComment( String source )
	{
		return source;
	}

	@Override
	public boolean supportLevel( int level )
	{
		return true;
	}

	@Override
	public boolean supportDebugLevel( int level )
	{
		return true;
	}

	@Override
	public boolean supportDebug( )
	{
		return true;
	}

}