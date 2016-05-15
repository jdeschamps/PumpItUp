package data;

public enum Function {
	RAT("RAT"), INC("INC"), DEC("DEC"), STP("STP"), JMP("JMP"), PRI("PRI"), PRL("PRL"), LOP("LOP"), LPS("LPS"), LPE("LPE"), 
		PAS("PAS"), IF("IF"), EVN("EVN"), EVS("EVS"), EVR("EVR"), BEP("BEP"), OUT("OUT");
	
	String name;
	public static String[] availableFunction = {"RAT", "INC", "DEC", "STP", "JMP", "PRI", "PRL", "LOP", "LPS", "LPE", 
			"PAS", "IF", "EVN", "EVS", "EVR", "BEP", "OUT"};
	
	Function(String s){
		name = s;
	}
	public String getName(){
		return name;
	}
	public String[] getAvailableFunctions(){
		return availableFunction;
	}
	public int getNumber(){
		return availableFunction.length;
	}
}
  