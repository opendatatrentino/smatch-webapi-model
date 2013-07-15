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
 * Configuration
 *
 * Version: 1.0
 *
 * Date: Jan 26, 2010
 *
 */
package it.unitn.disi.smatch.webapi.model;

import it.unitn.disi.smatch.webapi.model.exceptions.PropertyFiletException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * WebApiClient config properties accessor
 * 
 * @author Sergey Kanshin kanshin@disi.unitn.it
 *
 */
public class Configuration {

    private static Logger log = LoggerFactory.getLogger(Configuration.class);

    private static final String PROPERTIES_FILE_NAME =
            "smatch-webapi-model.properties";
    private static Properties props;

    protected Configuration() {
    }

    static {
        String baseDir = System.getProperty("basedir");
        String rootPath;
        if (null != baseDir) {
            rootPath = new File(baseDir).getAbsolutePath() + File.separator;
        } else {
            rootPath = new File(".").getAbsolutePath() + File.separator;
        }
        rootPath+="conf"+File.separator;
        props = loadPropertiesByName(PROPERTIES_FILE_NAME, rootPath);
    }

    protected static Properties loadPropertiesByName(String name, String rootPath) {
        File file = new File(rootPath + name);
        Properties p = new Properties();
        try {
            if (file.exists()) {
                log.info("Loading property file '" + name + "' from path '"
                        + rootPath + "'");
                p.load(new FileInputStream(file));
            } else {
                log.info("Loading property file '" + name + "' from CLASSPATH");
                InputStream in = Thread.currentThread().getContextClassLoader().
                        getResourceAsStream(name);
                if (null != in) {
                    p.load(in);
                } else {
                    log.error("Error load property file '" + name + "'");
                    throw new PropertyFiletException("Error load property file '"
                            + name + "'");
                }
            }
        } catch (IOException e) {
            log.error("Error load property file '" + name + "'", e);
        }
        return p;
    }

    public static String getString(String key) {
        try {
            return props.getProperty(key);
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }

    public static String getString(String key, Object... args) {
    	Object newArgs[] = new Object[args.length];
    	int i=0;
        for (Object arg : args) {
            if (arg == null) {
                newArgs[i] = null;
            } else {
                newArgs[i] = arg.toString();
            }
            i++;
        }
        return MessageFormat.format(getString(key), newArgs);
    }
}