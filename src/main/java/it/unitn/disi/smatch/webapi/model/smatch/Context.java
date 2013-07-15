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
package it.unitn.disi.smatch.webapi.model.smatch;

import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * <i>Context</i> represents a matching context for S-Match. It is a simple tree
 * of Strings with a root node and a list of children.
 * 
 * @author Moaz Reyad <reyad@disi.unitn.it>
 * @date Jul 11, 2013
 */
public class Context {    
 
    private String contextName;
    private String rootName;
    private List<String> nodes;
    
    public Context(String contextName, String rootName, List<String> nodes){
        this.contextName = contextName;
        this.rootName = rootName;
        this.nodes = nodes;
    }
    
    public JSONObject toJsonObject() throws JSONException{

        JSONObject jContext = new JSONObject();
        JSONObject jRoot = new JSONObject();        
        JSONArray jNodeList = new JSONArray();
  
        for (String node : nodes) {
            jNodeList.put(node);
        }
        
        jRoot.put(rootName, nodes);
        jContext.put(contextName, jRoot);
        
        return jContext;
    }
}
