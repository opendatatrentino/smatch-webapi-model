/*******************************************************************************
 * Copyright 2012-2013 University of Trento - Department of Information
 * Engineering and Computer Science (DISI)
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License
 * (LGPL) version 2.1 which accompanies this distribution, and is available at
 *
 * http://www.gnu.org/licenses/lgpl-2.1.html
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 ******************************************************************************/ 

/**
 * 
 */
package it.unitn.disi.smatch.webapi.model.exceptions;

/**
 * An exception that is thrown when a type mismatch error occurs.
 * 
 * @author kanshin
 *
 */
public class TypeMismatchException extends RuntimeException {

	private static final long serialVersionUID = 3366613896846109660L;

	public TypeMismatchException(String msg) {
		super(msg);
	}
	
}
