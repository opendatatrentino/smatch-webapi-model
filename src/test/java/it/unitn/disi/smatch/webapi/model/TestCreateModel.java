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
package it.unitn.disi.smatch.webapi.model;

import it.unitn.disi.smatch.webapi.model.exceptions.UnknownRelationException;
import it.unitn.disi.smatch.webapi.model.smatch.Context;
import it.unitn.disi.smatch.webapi.model.smatch.Correspondence;
import it.unitn.disi.smatch.webapi.model.smatch.CorrespondenceItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static junit.framework.Assert.assertNotNull;
import junit.framework.TestCase;

/**
 * A unit test for S-Match
 *
 * @author Moaz Reyad <reyad@disi.unitn.it>
 * @date Jul 11, 2013
 */
public class TestCreateModel extends TestCase {

    public TestCreateModel() {
        super("Test Creating an S-Match Web API Model");
    }

    public void testCreateModel() {

        String sourceContextRoot = "neve luogo";

        List<String> sourceContextNodes = Arrays.asList("codice",
                "nome",
                "nome breve",
                "quota",
                "latitudine",
                "longitudine");

        Context context = new Context("SourceContext", sourceContextRoot,
                sourceContextNodes);

        assertNotNull("Context is null", context);

        CorrespondenceItem itemName = null;
        CorrespondenceItem itemLatitude = null;
        CorrespondenceItem itemWrong = null;

        try {
            itemName = new CorrespondenceItem("nome breve", "nome", '>');
            itemLatitude = new CorrespondenceItem("latitudine", "latitudine", '<');
        } catch (UnknownRelationException ex) {
            Logger.getLogger(TestCreateModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Create an element with a wrong relation
        try {
            itemWrong = new CorrespondenceItem("nome breve", "nome", '/');

        } catch (UnknownRelationException ex) {
            System.out.println("Exception is thrown correctly: " + ex.getMessage());
        }


        assertNotNull("CorrespondenceItem is null", itemName);
        assertNotNull("CorrespondenceItem is null", itemLatitude);
        assertNull("Wrong CorrespondenceItem is not null", itemWrong);

        List<CorrespondenceItem> correspondenceItems =
                new ArrayList<CorrespondenceItem>();

        correspondenceItems.add(itemName);
        correspondenceItems.add(itemLatitude);

        Correspondence correspondence = new Correspondence(correspondenceItems);

        assertNotNull("Correspondence is null", correspondence);

        correspondenceItems = correspondence.getCorrespondenceItems();

        assertNotNull("Correspondence Items is null", correspondenceItems);

        for (CorrespondenceItem item : correspondenceItems) {
            System.out.print(item.getSource());
            System.out.print(item.getRelation());
            System.out.println(item.getTarget());
        }
    }
}
