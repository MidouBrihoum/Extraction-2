package xml_pack;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Traitement {

	
	
	
	
	
	
	void traite(){
		Element globalICE = GetGlobalElementFromXmlFileName("ICE.XML");  // retrouve l'element globale de ICE
		Element globalIBC = GetGlobalElementFromXmlFileName("IBC.XML"); // retrouve l'element globale de IBC 
		
		InterfaceIBC_ICE ICE = new GenerateInterfaceFromGElement(globalICE).Getinterface();  // retrouve l'interface depuis l'element globale
		InterfaceIBC_ICE IBC = new GenerateInterfaceFromGElement(globalIBC).Getinterface();// retrouve l'interface depuis l'element globale

		CompareInterfaces compareinterface = new  CompareInterfaces(IBC,ICE); // instancier la classe qui compare les interfaces 
		
	System.out.println("la similarité totale est: "+compareinterface.Compare()); 
		
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
