package xml_pack;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.File;

public class GenerateInterfaceFromGElement {
	
	Element GlobalElement;
	


public GenerateInterfaceFromGElement() {
	Getinterface();

		

	}





public GenerateInterfaceFromGElement(Element globalElement) { // constructor
	super();
	GlobalElement = globalElement;
}





InterfaceIBC_ICE Getinterface(){
	
	List<Operation> operationList;
	List<String> KeywordsList;

	
	
	GetOperation Operations = new GetOperation(GlobalElement);
	operationList = Operations.getOperationList();
	
	GetKeyword Keyword = new GetKeyword(GlobalElement);
	KeywordsList =  Keyword.getKeyword();
	
	InterfaceIBC_ICE ibc = new InterfaceIBC_ICE ( KeywordsList, operationList);
	return ibc;
	
	
}






//------------------------- Fonctions --------------------------------
public Element GetGlobalElementFromXmlFileName (String s){

	File ibc = new File(s);
	Document	IBCdoc = getDocumentFromXmlFileName (ibc); // retourne document depuis le nom du fichier XML
	
	Element GlobalElement = IBCdoc.getDocumentElement(); // retourne element globale du docment
return GlobalElement;
}








 Document getDocumentFromXmlFileName (File f)

{

	Document doc=null;

	try {
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.parse(f);
		doc.getDocumentElement().normalize();
		
	} catch(Exception e ){
		
	}
	
	return doc;
	
	
}

 
 
 
 
 
 
public static void main(String [] args){
	new GenerateInterfaceFromGElement();
}
}


