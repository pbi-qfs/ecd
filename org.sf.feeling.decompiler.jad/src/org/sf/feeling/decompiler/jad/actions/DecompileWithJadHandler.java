/*******************************************************************************
 * Copyright (c) 2017 Chen Chao(cnfree2000@hotmail.com).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Chen Chao  - initial API and implementation
 *******************************************************************************/

package org.sf.feeling.decompiler.jad.actions;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.sf.feeling.decompiler.actions.BaseDecompilerHandler;
import org.sf.feeling.decompiler.jad.JadDecompilerPlugin;

public class DecompileWithJadHandler extends BaseDecompilerHandler
{

	public Object execute( ExecutionEvent event ) throws ExecutionException
	{
		return handleDecompile( JadDecompilerPlugin.decompilerType );
	}

}