/*******************************************************************************
 * Copyright (c) 2017 Chen Chao and other ECD project contributors.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.sf.feeling.decompiler.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.eclipse.jdt.internal.compiler.classfmt.ClassFormatException;
import org.eclipse.jdt.internal.compiler.util.JRTUtil;

public class JarClassExtractor
{

	/**
	 * extracts class files from jar/zip archive or modules to specified path.
	 * See <code>IDecompiler</code> documentation for the format of pareameters.
	 */
	public static void extract( String archivePath, String packege, String className, boolean inner, String to )
			throws IOException
	{
		if ( archivePath.endsWith( JRTUtil.JRT_FS_JAR ) )
		{
			extractClassFromJrt( archivePath, packege, className, to );
		}
		else
		{
			extractClassesFromJar( archivePath, packege, className, inner, to );
		}
	}

	private static void extractClassFromJrt( String archivePath, String packege, String className, String to )
			throws IOException, FileNotFoundException
	{
		File outputFile = new File( to + File.separatorChar + className );
		try (FileOutputStream outputStream = new FileOutputStream( outputFile ))
		{
			File jrtPath = new File( archivePath );
			List<String> modules = JRTUtil.getModulesDeclaringPackage( jrtPath, packege, null );
			String moduleRelativePath = packege + "/" + className;
			byte[] content = findModuleWithFile( jrtPath, modules, moduleRelativePath );
			outputStream.write( content );
		}
		catch ( ClassFormatException e )
		{
			e.printStackTrace( );
			throw new RuntimeException( "Unable to read JRT file", e );
		}
	}

	private static byte[] findModuleWithFile( File jrtPath, List<String> modules, String moduleRelativeClassPath )
			throws IOException, ClassFormatException
	{
		for ( String module : modules )
		{
			byte[] content = JRTUtil.getClassfileContent( jrtPath, moduleRelativeClassPath, module );
			if ( content != null )
			{
				return content;
			}
		}
		throw new RuntimeException( "No module in JRT contains class " + moduleRelativeClassPath );
	}

	private static void extractClassesFromJar( String archivePath, String packege, String className, boolean inner,
			String to ) throws IOException, FileNotFoundException
	{
		ZipFile archive = new ZipFile( archivePath );
		List entries = findRelevant( archive, packege, className, inner );
		InputStream in = null;
		OutputStream out = null;
		byte[] buffer = new byte[2048];
		ZipEntry entry;
		String outFile;
		int lastSep, amountRead;

		for ( int i = 0; i < entries.size( ); i++ )
		{
			entry = (ZipEntry) entries.get( i );
			outFile = entry.getName( );
			if ( ( lastSep = outFile.lastIndexOf( '/' ) ) != -1 )
				outFile = outFile.substring( lastSep );

			try
			{
				in = archive.getInputStream( entry );
				if ( in == null )
					throw new IOException( "Zip file entry <" //$NON-NLS-1$
							+ entry.getName( )
							+ "> not found" ); //$NON-NLS-1$
				out = new FileOutputStream( to + File.separator + outFile );

				while ( ( amountRead = in.read( buffer ) ) != -1 )
					out.write( buffer, 0, amountRead );
			}
			finally
			{
				if ( in != null )
					in.close( );
				if ( out != null )
					out.close( );
			}
		}
	}

	private static List findRelevant( ZipFile archive, String packege, String className, boolean inner )
	{
		String entryName = ( packege.length( ) == 0 ) ? className
				: packege
						+ "/" //$NON-NLS-1$
						+ className;
		String innerPrefix = entryName.substring( 0, entryName.length( ) - 6 ) + "$"; //$NON-NLS-1$
		// strip .class + $
		Enumeration entries = archive.entries( );
		ZipEntry entry;
		String name;
		ArrayList relevant = new ArrayList( );

		while ( entries.hasMoreElements( ) )
		{
			entry = (ZipEntry) entries.nextElement( );
			name = entry.getName( );
			if ( name.equals( entryName ) || ( name.startsWith( innerPrefix ) && inner ) )
				relevant.add( entry );
		}
		return relevant;
	}
}