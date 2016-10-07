package com.tokbox.android.accpack.screensharing.util;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;


public class TokBoxXML {

    private Document xml;

    public TokBoxXML(String xmlString) throws Exception{

        try {
            this.xml = TokBoxUtils.setupDocument(xmlString);
        } catch(IOException ioe) {
            throw new Exception(ioe.toString());
        } catch(ParserConfigurationException pce) {
            throw new Exception(pce.toString());
        } catch(SAXException saxe) {
            throw new Exception(saxe.toString());
        }
    }


    public boolean hasElement(String elementName, String parentElement) {
        Node parentNode = TokBoxUtils.parseXML(parentElement, this.xml.getElementsByTagName(parentElement));
        if(parentNode == null) {
            return false;
        }
        Node searchNode = TokBoxUtils.parseXML(elementName, parentNode.getChildNodes());

        return null != searchNode;
    }

    public String getElementValue(String elementName, String parentElement) {
        Node parentNode = TokBoxUtils.parseXML(parentElement, this.xml.getElementsByTagName(parentElement));
        Node searchNode = TokBoxUtils.parseXML(elementName, parentNode.getChildNodes());

        return null == searchNode ? null : searchNode.getTextContent();
    }


}