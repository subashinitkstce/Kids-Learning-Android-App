package com.example.helloworld;


import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import com.example.helloworld.Objects;
 
public class SAXXMLHandler extends DefaultHandler {
 
    private List<Objects> objects;
    private String tempVal;
    private Objects tempObj;
 
    public SAXXMLHandler() {
        objects = new ArrayList<Objects>();
    }
 
    public List<Objects> getObjects() {
        return objects;
    }
 
    // Event Handlers
    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {
        // reset
        tempVal = "";
        if (qName.equalsIgnoreCase("row")) {
            // create a new instance of employee
            tempObj = new Objects();
        }
    }
 
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        tempVal = new String(ch, start, length);
    }
 
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equalsIgnoreCase("row")) {
            // add it to the list
            objects.add(tempObj);
        } else if (qName.equalsIgnoreCase("name")) {
        	//System.out.println(tempVal);
        	tempObj.setName(tempVal);
        } else if (qName.equalsIgnoreCase("nameta")) {
        	//System.out.println(tempVal);
        	tempObj.setNameta(tempVal);
        } else if (qName.equalsIgnoreCase("image")) {
        	tempObj.setImage(tempVal);
        } else if (qName.equalsIgnoreCase("show")) {
        	tempObj.setShow(Boolean.parseBoolean(tempVal));
        } else if (qName.equalsIgnoreCase("audio")) {
        	tempObj.setAudio(tempVal);
        } else if (qName.equalsIgnoreCase("custom")) {
        	tempObj.setCustom(Boolean.parseBoolean(tempVal));
        } 
    }
}