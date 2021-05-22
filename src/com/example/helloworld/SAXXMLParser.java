package com.example.helloworld;

import java.io.InputStream;
import java.util.List;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import com.example.helloworld.Objects;
import android.util.Log;
 
public class SAXXMLParser {
    public static List<Objects> parse(InputStream is) {
        List<Objects> objects = null;
        try {
            // create a XMLReader from SAXParser
            XMLReader xmlReader = SAXParserFactory.newInstance().newSAXParser()
                    .getXMLReader();
            // create a SAXXMLHandler
            SAXXMLHandler saxHandler = new SAXXMLHandler();
            // store handler in XMLReader
            xmlReader.setContentHandler(saxHandler);
            // the process starts
            xmlReader.parse(new InputSource(is));
            // get the `Employee list`
            objects = saxHandler.getObjects();
 
        } catch (Exception ex) {
            Log.d("XML", "SAXXMLParser: parse() failed");
        }
 
        // return Employee list
        return objects;
    }
}
