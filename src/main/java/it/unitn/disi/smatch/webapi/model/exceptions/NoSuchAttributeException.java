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
 * NoSuchAttributeException.java
 * Apr 20, 2010
 */
package it.unitn.disi.smatch.webapi.model.exceptions;

/**
 *
 *
 * @author Sergey Kanshin    kanshin@disi.unitn.it
 * @date Apr 20, 2010
 */
public class NoSuchAttributeException extends RuntimeException {

	private static final long serialVersionUID = -2856755657321691654L;

	public NoSuchAttributeException(String msg) {
		super(msg);
	}
	
}
