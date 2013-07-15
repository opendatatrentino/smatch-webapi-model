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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.smatch.webapi.model.exceptions;

/**
 * An exception that is thrown when an error is found while loading the property
 * file.
 * 
 * @author Moaz Reyad <reyad@disi.unitn.it>
 * @date Jul 11, 2013
 */
public class PropertyFiletException extends RuntimeException {

    public PropertyFiletException(String msg) {
        super(msg);
    }
}
