package lector;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
 
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
 
import org.dcm4che2.data.Tag;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
//import viewer;

public class parser extends DefaultHandler {
	    List<PACSAcces> acceso;
	    String bookXmlFileName;
	    String tmpValue;
	     PACSAcces accesTmp;
	    SimpleDateFormat sdf= new SimpleDateFormat("yy-MM-dd");
	    
public parser (String bookXmlFileName) {
        this.bookXmlFileName = bookXmlFileName;
	        acceso = new ArrayList<PACSAcces>();
	        parseDocument();
	        printDatas();
	    }
private void parseDocument() {
	        // parse
	        SAXParserFactory factory = SAXParserFactory.newInstance();
	        try {
	            SAXParser parsero = factory.newSAXParser();
	            parsero.parse(bookXmlFileName, this);
	        } catch (ParserConfigurationException e) {
            System.out.println("ParserConfig error");
	        } catch (SAXException e) {
	            System.out.println("SAXException : xml not well formed");
	        } catch (IOException e) {
	            System.out.println("IO error");
	        }
	    }
	private void printDatas() {
	       // System.out.println(acceso.size());
	        for (PACSAcces tmpB : acceso) {
	            System.out.println(tmpB.toString());
	        }
	    }

	    @Override
	    public void startElement(String s, String s1, String elementName, Attributes attributes) throws SAXException {
	        // if current element is pacacces , create new pacaccess
	        // clear tmpValue on start of element
	 
	        if (elementName.equalsIgnoreCase("select")) {
	            accesTmp = new PACSAcces();
	           // accesTmp.getPatients();
	            
	            //accesTMP.getStudies();
	            //accesTmp.getPatients().setName.(attributes.getValue("variables"));
	        }
	        // if current element is publisher
	        //if (elementName.equalsIgnoreCase("publisher")) {
	         //   accesTmp.setPublisher(attributes.getValue("country"));
	       // }
	    }
	    @Override
	    public void endElement(String s, String s1, String element) throws SAXException {
	        // if end of book element add to list
	        if (element.equals("select")) {
	        	System.out.println("herewego");
	           // acceso.add(accesTmp);
	        }
	       
	    }
	    @Override
	    public void characters(char[] ac, int i, int j) throws SAXException {
	        tmpValue = new String(ac, i, j);
	    }
	    
/*public static void main(String[] args) {
	        new parser("E:/libro.xml");
	    }*/
	}