package data;

public enum InstructionTimeUnit {
	HOUR("hr"), MIN("min"), SEC("sec");
	
	String name;
	
	InstructionTimeUnit(String s){
		name = s;
	}
	public String getName(){
		return name;
	}
}
  