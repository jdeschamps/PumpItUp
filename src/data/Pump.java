package data;

import java.util.Collections;

public class Pump {

	private String name;
	private int address;
	private int diameter;
	private Program program;

	public Pump(int address){
		this.name = "Unnamed";
		if(address>=0 && address<100){
			this.address = address;
		} else {
			this.address = 0;
		}
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
		if(address>=0 && address<100){
			this.address = address;
		}
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
	
	public String[] getPhaseList(){
		return program.getPhaseList();
	}
	
	public int getNumberPhases(){
		return program.getNumberPhases();
	}
	
	public Phase getPhase(int index){
		return program.getPhase(index);
	}
	
	public boolean hasPhase(int index){
		return (index>=0 && index<getNumberPhases());
	}
	
	public void moveUpPhase(int i){
		program.moveUpPhase(i);
	}
	
	public void moveDownPhase(int i){
		program.moveDownPhase(i);
	}
	
	public void addPhase(){
		program.addPhase();
	}

	public void removePhase(int i){
		program.removePhase(i);
	}
	
}
