package data;

public class Pump {

	private String name;
	private int address;
	private int diameter;
	private Program program;

	public Pump(){
		this.name = "Unnamed";
		this.address = 0;
		this.diameter = 12;
		this.program =  new Program();
	}

	public Pump(String name, int address, int diameter, Program program){
		this.name = name;
		this.address = address;
		this.diameter = diameter;
		this.program =  program;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setAddress(int address){
		this.address = address;
	}
	
	public int getAddress(){
		return address;
	}
	
	public void setDiameter(int diameter){
		this.diameter = diameter;
	}
	
	public int getDiameter(){
		return diameter;
	}
	
	public void setProgram(Program prog){
		this.program =  prog;
	}
	
	public Program getProgram(){
		return program;
	}
}
