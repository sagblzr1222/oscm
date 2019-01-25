/*******************************************************************************
 *                                                                              
 *  Copyright FUJITSU LIMITED 2019                                           
 *                                                                                                                                 
 *  Creation Date: 24.01.2019                                                      
 *                                                                              
 *******************************************************************************/

package org.oscm.app.vmware.business.balancer;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

/**
 * @author goebel
 *
 */
class XMLHelper {

    protected static String getAttributeValue(Node node, String name) {
        return getAttributeValue(node, name, "");
    }

    protected static String getAttributeValue(Node node, String name,
            String defaultValue) {
        Node attr = node.getAttributes().getNamedItem(name);
        if (attr != null)
            return attr.getNodeValue();
        return defaultValue;

    }

    protected static Document convertToDocument(String string)
            throws Exception {

        DocumentBuilderFactory dfactory = DocumentBuilderFactory.newInstance();
        dfactory.setValidating(false);
        dfactory.setIgnoringElementContentWhitespace(true);
        DocumentBuilder builder = dfactory.newDocumentBuilder();
        Document doc = builder.parse(new InputSource(new StringReader(string)));
        return doc;
    }

}
