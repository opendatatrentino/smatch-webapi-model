/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.smatch.webapi.model.exceptions;

/**
 *
 * An exception that is thrown when the value of the relation character of the
 * correspondence item is not one of the following: "=<>!LMX?"
 *
 * @author Moaz Reyad <reyad@disi.unitn.it>
 * @date Jul 11, 2013
 */
public class UnknownRelationException extends Exception {

    /**
     * Constructs an instance of
     * <code>UnknownRelationException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public UnknownRelationException(String msg) {
        super(msg);
    }
}
