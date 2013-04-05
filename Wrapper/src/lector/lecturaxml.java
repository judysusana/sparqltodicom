package lector;

import java.io.File;
import java.util.ArrayList;
//import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
//import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import viewer.*;

import viewer.Patient;

public class lecturaxml {
	
	
public void  leer(){
		
		
		try {
			  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			  DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			  Document doc = dBuilder.parse(new File("E:/libro.xml"));
			  doc.getDocumentElement().normalize();

			  System.out.println("El elemento raíz es: " + doc.getDocumentElement().getNodeName());
			    
			  NodeList listaAtributos = doc.getElementsByTagName("select");

			  for (int i = 0; i < listaAtributos.getLength(); i ++) {

			    Node select = listaAtributos.item(i);
			      
			    System.out.println("select="+select.getNodeName());
			   
			    if (select.getNodeType() == Node.ELEMENT_NODE) {  // tenga atributos quiere decir que por definicón es un Node (nodo)

		            Element elemento = (Element) select;   
		            //System.out.println("hijoselect : " + getTagValue("variable", elemento));
		            
		            NodeList listavariable =elemento.getElementsByTagName("variable");
		            String arreglo[]= new String[listavariable.getLength()]; //guardo en un arreglo tipo string
		            for (int j=0; j<listavariable.getLength(); j++){
		            	Node variable =listavariable.item(j);
		            	
		            	if (variable.getNodeType()==Node.ELEMENT_NODE){
		            	Element var =(Element) variable;
		            	//System.out.println("variable"+getTagValue("etiqueta", var));
		            	arreglo[j]= getTagValue("etiqueta", var) ;
		                
		                System.out.println("variable==="+arreglo[j]);
		            	
		            	
		            	}
		            	
		            }
		            }
			    }
		            
		               
		         
		            
		       NodeList listaPatron = doc.getElementsByTagName("where");

		      	  for (int k = 0; k < listaPatron.getLength(); k ++) {

		      	    Node where = listaPatron.item(k);
		      	    System.out.println("where="+where.getNodeName());

		      	    if (where.getNodeType() == Node.ELEMENT_NODE) {

		                  Element patron = (Element) where;
		                  NodeList listavariables =patron.getElementsByTagName("patron");
		                  for (int l=0; l<listavariables.getLength(); l++){
		                  	Node variables =listavariables.item(l);
		                  	
		                  	if (variables.getNodeType()==Node.ELEMENT_NODE){
		                  	Element vari =(Element) variables;
		                  	System.out.println("variable=="+getTagValue("tripla", vari));
		                  	}
		                  	
		                  }
		                           

			    }
		    }
		      	  
		      	  NodeList listafiltro = doc.getElementsByTagName("filter");

		    	  for (int i = 0; i < listafiltro.getLength(); i ++) {

		    	    Node filter = listafiltro.item(i);
		    	      
		    	    System.out.println("filtro="+filter.getNodeName());
		    	   
		    	    if (filter.getNodeType() == Node.ELEMENT_NODE) {  

		                Element filtro = (Element) filter;   
		                               
		                NodeList listafiltros =filtro.getElementsByTagName("filtrovariable");
		               // NodeList listavalor=filtro.getElementsByTagName("");
		                for (int j=0; j<listafiltros.getLength(); j++){
		                	Node variablefilter =listafiltros.item(j);
		                	
		                	if (variablefilter.getNodeType()==Node.ELEMENT_NODE){
		                	Element varfilter =(Element) variablefilter;
		                	System.out.println("filtro"+getTagValue("filtro", varfilter));
		                	System.out.println("valor"+getTagValue("valorfiltro", varfilter));
		                	}
		                	
		                }
		                }
		    	    }
		  }
			    catch (Exception e) {
		    e.printStackTrace();
		  }
	}
	
public void CreatePACSAcces(){
	//XDocument xdoc1 = XDocument.Load("E:/libro.xml");
	PACSAcces consulta = new PACSAcces(); 
	ArrayList<Patient> patients; 
	String id="";
	String argumentospaciente="";
	
	patients=consulta.getPatients();
	
	
	                                             
		for (int p=0; p<patients.size();p++){
			patients.get(p).getName();
			id=patients.get(p).getId();
			//System.out.println("id=="+id);
			consulta.getStudies(id);
			System.out.println("Study's ToString:  "+consulta.getStudies(id).get(p).getId().toString());
			//System.out.println("Patient's name:  "+patients.get(p).getName().toString());
			
			}
		
	}






 public static void main(String argv[]) {

  lecturaxml lectura=new lecturaxml();
  lectura.leer();
  
  lectura.CreatePACSAcces();
                                           
		
  //PACSAcces consulta = new PACSAcces(); 
	//consulta.getPatients();
  //consulta.getStudies("7rAgWJ");    
  //System.out.println("imprimase");

 }

 private static String getTagValue(String sTag, Element eElement)
 {
	  NodeList nlList= eElement.getElementsByTagName(sTag).item(0).getChildNodes();
	  
	   Node nValue = (Node) nlList.item(0);

	  return nValue.getNodeValue();

 }

}
