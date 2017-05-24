package xml_pack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.tools.JavaCompiler;

public class CompareInterfaces {
InterfaceIBC_ICE ice ;
InterfaceIBC_ICE ibc ;


public CompareInterfaces(InterfaceIBC_ICE ibc, InterfaceIBC_ICE ice ) { // constructeur
	super();
	this.ice = ice;
	this.ibc = ibc;
}

float Compare(){  // resultat final
	float Sim=(CompareKeywords()+CompareOperations())/2;
	return Sim;
}


float CompareKeywords(){  // compare les keywords 
	Float Sim;
	List<String> IceKw =ice.getKeywordsList();
	List<String> IbcKw = ibc.getKeywordsList();
int total = IbcKw.size();
System.out.println( "le nombre total des keywords dans IBC "+total) ;

	IbcKw.retainAll( IceKw);

	int found = IbcKw.size();
	
	System.out.println( "le nombre de keywords trouvé dans ice "+found) ;

try{		
Sim= ((float)found/(float)total)*100 ;} catch(Exception e) { Sim=(float) 0;}
	
System.out.println( "la similarité des keywords est "+Sim) ;

	return Sim;}



float CompareOperations(){ // compare les operations
	float Sim=0;
	float maxsim=0;
	float tempsim;
	List<Operation> IceOp =ice.getOperationList();
	List<Operation> IbcOp = ibc.getOperationList();
	
	
	for (int i = 0; i < IbcOp.size(); i++){
		maxsim=0;
		for (int j = 0; j < IceOp.size(); j++) {
			
		tempsim =	CompareOperation(IbcOp.get(i),IceOp.get(j));
			
		if (tempsim>maxsim) { maxsim=tempsim; }
		}
		Sim=Sim+maxsim;
	}
	System.out.println( "le nombre  total d'operations dans IBC "+IbcOp.size()) ;
	
	System.out.println( "la similarité: des operations entre IBC et le ICE "+Sim/IbcOp.size()) ;


	return Sim/IbcOp.size();
	}


float CompareOperation(Operation a,Operation b){ // comparaison entre deux operations ( utilisé dans compareOperations )

	 float opname=CompareOpname(a.opname,b.opname);
	 float input=ComparePart(a.input,b.input);
	 float output=ComparePart(a.output,b.output);
	 float precond=ComparePart(a.precond,b.precond);
	 float postcond=ComparePart(a.postcond,b.postcond);
	
		System.out.println( "la similarité  d'operations entre "+a.opname+" et "+b.opname+" est: " +((opname+input+output+precond+postcond)/5));
	return (opname+input+output+precond+postcond)/5;

}

float CompareOpname(String a,String b) { // compare les noms de deux operations  ( utilisé dans compareOperation )
	if(a.equals(b)){
		System.out.println( "sim entre les noms de l'operation: "+a +" et "+b+" = 100") ;

		return (float) 100;
	}
	else{
		System.out.println( "sim entre les noms de l'operation: "+a +" et "+b+" = 0") ;

		return (float) 0;
		
	}
	

	
}

float ComparePart(List<Part> part1,List<Part> part2) {  // compare les paramétres part de deux operations  ( utilisé dans compareOperation )
	float Sim=0;	
try{	
	
	List<Part> IcePart =part2;
	List<Part> IbcPart = part1;
	
int total = IbcPart.size();
int total2 = IcePart.size();
total= Math.max(total,total2);
int found=0;
for (int i = 0; i < IbcPart.size(); i++) {
	for (int j = 0; j < IcePart.size(); j++) {
		if(((IbcPart.get(i).name).equals(IcePart.get(j).name))&&((IbcPart.get(i).type).equals(IcePart.get(j).type))){
			found++;
		}
	}
}
if(total!=0){		
Sim= ((float)found/(float)total)*100 ; }
else {Sim=100;} 
System.out.print( " le nbr de paramétre total = "+total) ;
System.out.print( " le nbr de paramétre trouvé dans ice =  "+found) ;
System.out.print( " la similarité est  "+Sim) ;
System.out.println( "----------------") ;


}catch(Exception e) {
	System.out.println( " Rani fel catch") ;

	Sim=(float) 0;}

	return Sim;
	
} 
	}
	










