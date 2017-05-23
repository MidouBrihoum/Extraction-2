package xml_pack;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Traitement {

	
	
	
	
	
	
	void traite(){
		Element globalICE = GetGlobalElementFromXmlFileName("ICE.XML");
		Element globalIBC = GetGlobalElementFromXmlFileName("IBC.XML");
		
		InterfaceIBC_ICE ICE = new GenerateInterfaceFromGElement(globalICE).Getinterface();
		InterfaceIBC_ICE IBC = new GenerateInterfaceFromGElement(globalIBC).Getinterface();

		CompareInterfaces compare = new  CompareInterfaces(IBC,ICE);
		
		compare.Compare();
		
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
	 
	 
	 
	 
	 public static void main(String []args){
			
		 new Traitement().traite();
		 
		}

	 
}
