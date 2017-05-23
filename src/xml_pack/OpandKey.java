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

public class OpandKey {
	List<Operation> operationList;
	List<String> KeywordsList;


public OpandKey() {
		test();

		
		for (int i = 0; i < KeywordsList.size(); i++) {

			System.out.println("key numero "+(i+1)+":");


			System.out.println("partname: "+ KeywordsList.get(i));
			

			System.out.println("*******");
		}
		System.out.println("---------------------------");
	}


void test(){
	
	
	File ibc = new File("IBC.xml");
	Document	IBCdoc = getDocumentFromXmlFileName (ibc); // retourne document depuis le nom du fichier XML
	
	Element GlobalElement = IBCdoc.getDocumentElement(); // retourne element globale du docment
	
	GetOperation Operations = new GetOperation(GlobalElement);
	operationList = Operations.getOperationList();
	GetKeyword Keyword = new GetKeyword(GlobalElement);
	KeywordsList =  Keyword.getKeyword();
	
}


public Document getDocumentFromXmlFileName (File f)
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
	new OpandKey();
}
}


