package xml_pack;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Node;


import org.w3c.dom.Element;



public class GetKeyword {
	 File fXmlFile;	
	 List<String> Keyword;
	 Element GlobalElement;
	 
	 
	 
	 public List<String> getKeyword() {
			return Keyword;
		}
	 
	GetKeyword(Element e){
		this.GlobalElement=e;
		getkey();
	}
	
	void getkey(){
		Keyword = new ArrayList<String>(); 

		  try {

			
				
				Node Keywords = GlobalElement.getElementsByTagName("keywords").item(0);

				for (int temp = 0; temp < Keywords.getChildNodes().getLength(); temp++) {
					if (Keywords.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) Keywords;
				try{	Keyword.add(eElement.getElementsByTagName("Keyword").item(temp).getTextContent());} catch(Exception ex){}
					}
					
					 
				}
			    } catch (Exception e) {
				e.printStackTrace();
			    }
		  
		  }

	
	void print(){

		  for (int temp = 0; temp < Keyword.size(); temp++) {
			  try{
		  System.out.println(Keyword.get(temp).toString());} catch(Exception e){}
		  System.out.println("--------------");}
		  System.out.println("taille totale de la liste : "+ Keyword.size());
	}
		

	
}