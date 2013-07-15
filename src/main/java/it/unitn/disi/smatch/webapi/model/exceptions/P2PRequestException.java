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

import java.net.HttpURLConnection;

/**
 * An exception that is thrown when a P2P Request goes wrong
 * 
 * @author Viktor Pravdin <pravdin@disi.unitn.it>
 */
public class P2PRequestException extends RuntimeException {

    private int code;
    
    public P2PRequestException(String msg){
        this(msg, HttpURLConnection.HTTP_INTERNAL_ERROR);
    }
    
    /**
     * Constructs an instance of <code>P2PRequestException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public P2PRequestException(String msg, int code) {
        super(msg);
        this.code=code;
    }
    
    public int getCode(){
        return code;
    }
}
