/**
 * *****************************************************************************
 * Copyright 2012-2013 University of Trento - Department of Information
 * Engineering and Computer Science (DISI)
 *
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the GNU Lesser General Public License (LGPL)
 * version 2.1 which accompanies this distribution, and is available at
 *
 * http://www.gnu.org/licenses/lgpl-2.1.html
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 *****************************************************************************
 */

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.smatch.webapi.model.smatch;

import it.unitn.disi.smatch.webapi.model.exceptions.UnknownRelationException;

/**
 * <i>CorrespondenceItem</i> represents an item in the <i>Correspondence</i>. It
 * is a tuple of Source, Relation and Target.
 *
 * @author Moaz Reyad <reyad@disi.unitn.it>
 * @date Jul 11, 2013
 */
public class CorrespondenceItem {

    private char relation;
    private String source;
    private String target;
    
    // String of allowed chars for the relation 
    private static final String ALLOWED_RELATIONS = "=<>!LMX?";

    public CorrespondenceItem(String source, String target, char relation)
            throws UnknownRelationException {

        if (ALLOWED_RELATIONS.contains(String.valueOf(relation))) {
            this.source = source;
            this.target = target;
            this.relation = relation;
        } else {
            throw new UnknownRelationException("Relation " + relation
                    + " is not of the allowed values for relations: "
                    + ALLOWED_RELATIONS);
        }
    }

    public String getSource() {
        return source;
    }

    public String getTarget() {
        return target;
    }

    public char getRelation() {
        return relation;
    }
}
