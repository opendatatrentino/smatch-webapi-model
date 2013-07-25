/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.smatch.webapi.model.exceptions;

import java.lang.reflect.InvocationTargetException;

/**
 *
 * An exception that is thrown when a bad invocation occurs
 * 
 * @author Moaz Reyad <reyad@disi.unitn.it>
 * @date Jul 11, 2013
 */
public class BadInvoactionRequestException extends BadRequestException {

    /**
     * Constructs an instance of
     * <code>BadRequestException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public BadInvoactionRequestException(String msg, InvocationTargetException ex) {
        super(msg + " " + ex.getMessage());
    }
}
