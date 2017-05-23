package xml_pack;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Traitement {

	
	 static float sim=70;

	
	
	
	
	void traite(float i){
		Element globalIBC = GetGlobalElementFromXmlFileName("xml/IBC.XML"); // retrouve l'element globale de IBC 
		InterfaceIBC_ICE IBC = new GenerateInterfaceFromGElement(globalIBC).Getinterface();// retrouve l'interface depuis l'element globale

		
		Element GlobalDescription = GetGlobalElementFromXmlFileName("xml/descriptions.XML"); // retrouve l'element globale de IBC 
		NodeList Abstracts = GlobalDescription.getElementsByTagName("Abstract"); // Liste des abstract de la partie description du registre
		
		
		
		for (int temp = 0; temp < Abstracts.getLength(); temp++) { // loop pour chaque operation

			Node tempabst = Abstracts.item(temp); 
			Element abstractelement = (Element) tempabst; // element operaiton

			System.out.println("Comparer le IBC avec l'interface ICE du registre numero  "+temp); 
			
			
			InterfaceIBC_ICE ICE = new GenerateInterfaceFromGElement(abstractelement).Getinterface();  // retrouve l'interface depuis l'element globale

			CompareInterfaces compareinterface = new  CompareInterfaces(IBC,ICE); // instancier la classe qui compare les interfaces 
			float sim_result =compareinterface.Compare();
			System.out.println("la similarité totale est: "+sim_result); 
			System.out.println("la similarité souhaité est: "+sim); 
			
			if(sim_result>=sim){
				System.out.println("la similarité est suffisante"); 
				String filename= abstractelement.getAttribute("link").toString();
			System.out.println("le fichié de l'interface ice:"+filename); 
			} else {			System.out.println("la similarité n'est pas suffisante"); }

			
			
		
		}
		
		
		

		
		
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
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(true);
			factory.setXIncludeAware(true);
			
			DocumentBuilder dBuilder = factory.newDocumentBuilder();
			doc = dBuilder.parse(f);
			doc.getDocumentElement().normalize();
			
		} catch(Exception e ){
			
		}
		
		return doc;
		
		
	}
	 
	 
	 
	 
	 public static void main(String []args){
		 new Traitement().traite(sim);
		 
		}

	 
}
