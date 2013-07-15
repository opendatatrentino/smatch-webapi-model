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
 * JSONHelper.java
 */
package it.unitn.disi.smatch.webapi.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/**
 * A JSON helper class with utility methods 
 *
 * @author Sergey Kanshin <kanshin@disi.unitn.it>
 * @version Mar 2, 2011
 */
public class JSONHelper {

    public static final String TAG_VERSION = "version";

    public static final String TAG_STATUS = "status";

    public static final String TAG_TIME = "time";

    public static final String TAG_RESPONSE = "response";

    public static final String TAG_CODE = "code";

    public static final String TAG_MESSAGE = "message";

    public static final String TAG_ERROR = "error";

    public static final String TAG_REQUEST = "request";

    public static final String TAG_METHOD = "method";

    public static final String TAG_PARAMS = "parameters";

    public static final String TAG_URI = "uri";

    public static final String TAG_JSON_DATA = "jsondata";

    public static final String TAG_WEBAPI = "webapi";

    public static final String TAG_LOCALE = "locale";

    public static final String TAG_SID = "session_id";

    public static List<Long> getLongArray(JSONArray jArray) throws JSONException {
        List<Long> list = new ArrayList<Long>();
        if (null == jArray) {
            return list;
        }
        for (int i = 0; i < jArray.length(); i++) {
            list.add(jArray.getLong(i));
        }
        return list;
    }

    public static List<String> getStringArray(JSONArray jArray) throws
            JSONException {
        List<String> list = new ArrayList<String>();
        if (null == jArray) {
            return list;
        }
        for (int i = 0; i < jArray.length(); i++) {
            list.add(jArray.getString(i));
        }
        return list;
    }

    public static JSONArray getLongJSONArray(List<Long> list) {
        JSONArray jArray = new JSONArray();
        if (null == list) {
            return jArray;
        }
        for (Long l : list) {
            jArray.put(l);
        }
        return jArray;
    }

    public static JSONArray getStringJSONArray(List<String> list) {
        JSONArray jArray = new JSONArray();
        if (null == list) {
            return jArray;
        }
        for (String l : list) {
            jArray.put(l);
        }
        return jArray;
    }

    public static JSONObject getRequestBody(JSONObject request) throws
            JSONException {
        return request.getJSONObject(TAG_REQUEST);
    }

    public static JSONObject getResponseBody(JSONObject request) throws
            JSONException {
        return request.getJSONObject(TAG_RESPONSE);
    }

    public static Map<String, String> getParams(String query) {
        Map<String, String> map = new HashMap<String, String>();
        if (query != null) {
            String[] params = query.split("&");
            for (String param : params) {
                String[] pair = param.split("=");
                String name = pair[0];
                String value = null;
                if (pair.length > 1) {
                    value = pair[1];
                }
                map.put(name, value);
            }
        }
        if (!map.containsKey(TAG_LOCALE)) {
            map.put(TAG_LOCALE, "en");
        }
        return map;
    }

    public static Map<String, Object> getParams(JSONObject request) throws
            JSONException {
        Map<String, Object> params = new HashMap<String, Object>();
        JSONObject jParams = null;
        JSONObject jBody = request;
        if (request.has("request")) {
            // request contains the complete request
            jBody = getRequestBody(request);
            jParams = jBody.optJSONObject(TAG_PARAMS);
        } else if (request.has(TAG_PARAMS)) {
            // request contains the request body
            jParams = request.optJSONObject(TAG_PARAMS);
        }
        if (jParams != null) {
            Iterator it = jParams.keys();
            while (it.hasNext()) {
                Object obj = it.next();
                if (!(obj instanceof String)) {
                    throw new IllegalArgumentException("Unsupported key type: "
                            + obj.getClass());
                }
                String key = (String) obj;
                params.put(key, jParams.get(key));
            }
        }
        params.put(TAG_LOCALE, new Locale(jBody.optString(JSONHelper.TAG_LOCALE,
                "en")));
        return params;
    }

    public static boolean isFailed(JSONObject respBody) {
        return Status.FAIL.equals(Status.valueOf(respBody.optString(TAG_STATUS,
                Status.FAIL.name())));
    }

    public static JSONObject createRequest(JSONObject body, String method,
            String uri) throws JSONException {
        JSONObject req = new JSONObject();
        if (body != null) {
            req.put(TAG_REQUEST, body);
        }
        if (method != null) {
            req.put(TAG_METHOD, method);
        }
        if (uri != null) {
            req.put(TAG_URI, uri);
        }
        return req;
    }

    public static Document wrapJsonToXml(JSONObject obj) throws
            ParserConfigurationException {
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().
                newDocument();
        Element root = doc.createElement(TAG_WEBAPI);
        Element el = doc.createElement(TAG_JSON_DATA);
        Text txt = doc.createTextNode(obj.toString());
        el.appendChild(txt);
        root.appendChild(el);
        doc.appendChild(root);
        return doc;
    }

    public static JSONObject getJsonFromXml(Document doc) throws JSONException {
        NodeList list = doc.getElementsByTagName(TAG_JSON_DATA);
        JSONObject obj = null;
        if (list.getLength() > 0) {
            obj = new JSONObject(list.item(0).getTextContent());
        }
        return obj;
    }

    public static String getErrorMessage(JSONObject body) throws JSONException {
        if (body.has(TAG_ERROR)) {
            return body.getJSONObject(TAG_ERROR).optString(TAG_MESSAGE);
        }
        return null;
    }

    protected JSONHelper() {
    }
}
