package data;

public enum TimeUnit {
	HOUR("hr"), MIN("min"), SEC("sec");
	
	String name;
	
	TimeUnit(String s){
		name = s;
	}
	public String getName(){
		return name;
	}
}
  