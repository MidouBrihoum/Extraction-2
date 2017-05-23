package xml_pack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CompareInterfaces {
InterfaceIBC_ICE ice ;
InterfaceIBC_ICE ibc ;


public CompareInterfaces(InterfaceIBC_ICE ibc, InterfaceIBC_ICE ice ) {
	super();
	this.ice = ice;
	this.ibc = ibc;
}


Float CompareKeywords(){
	Float Sim;
	List<String> IceKw =ice.getKeywordsList();
	List<String> IbcKw = ibc.getKeywordsList();
int total = IbcKw.size();
System.out.println( "total "+total) ;

	IbcKw.retainAll( IceKw);

	int found = IbcKw.size();
	
	System.out.println( "found "+found) ;

try{		
Sim= ((float)found/(float)total)*100 ;} catch(Exception e) { Sim=(float) 0;}
	
	return Sim;}



float CompareOperations(){
	float Sim=0;
	float maxsim=0;
	float tempsim;
	List<Operation> IceOp =ice.getOperationList();
	List<Operation> IbcOp = ibc.getOperationList();
	
	
	for (int i = 0; i < IbcOp.size(); i++){
		for (int j = 0; j < IceOp.size(); j++) {
			
		tempsim =	CompareOperation(IbcOp.get(i),IceOp.get(j));
			
		if (tempsim>maxsim) { maxsim=tempsim; }
		}
		Sim=Sim+maxsim;
	}
	
	
	
	

	
	return Sim;}


float CompareOperation(Operation a,Operation b){

	 float opname=CompareOpname(a.opname,b.opname);
	 float input=ComparePart(a.input,b.input);
	 float output=ComparePart(a.output,b.output);
	 float precond=ComparePart(a.precond,b.precond);
	 float postcond=ComparePart(a.postcond,b.postcond);
	
	return (opname+input+output+precond+postcond)/5;
	
}

float CompareOpname(String a,String b) {
	if(a.equals(b)){
		return (float) 100;
	}
	else{
		return (float) 0;
	}
}

float ComparePart(List<Part> part1,List<Part> part2) {
	float Sim;
	List<Part> IcePart =part1;
	List<Part> IbcPart = part2;
int total = IbcPart.size();
int found=0;
for (int i = 0; i < IbcPart.size(); i++) {
	for (int j = 0; j < IcePart.size(); j++) {
		if(((IbcPart.get(i).name).equals(IcePart.get(j).name))&&((IbcPart.get(i).type).equals(IcePart.get(j).type))){
			found++;
		}
	}
}
try{		
Sim= ((float)found/(float)total)*100 ;} catch(Exception e) { Sim=(float) 0;}
	
	return Sim;
	}
	








public void Compare() {
	// TODO Auto-generated method stub
	
}
}
