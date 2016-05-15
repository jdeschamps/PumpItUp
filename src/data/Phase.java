package data;

import java.util.ArrayList;

public class Phase {

	
	private Function function = Function.STP;
	private String parameter = "";
	private ArrayList<Instruction> instructions;

	public Phase(){
	}
	
	public Phase(String function){
		this.function = Function.valueOf(function);
		instructions = new ArrayList<Instruction>();
	}

	public Phase(String function, String parameter, ArrayList<Instruction> instructions){
		this.function = Function.valueOf(function);
		this.parameter = parameter;
		this.instructions = instructions;
	}
	
	public Phase(String function, ArrayList<Instruction> instructions){
		this.function = Function.valueOf(function);
		this.instructions = instructions;
	}

	public void setFunction(String s){
		function = Function.valueOf(s);
	}
	
	public String getFunction(){
		return function.getName();
	}
	
	public void setParameter(String s){
		parameter = s;
	}
	
	public void addInstruction(Instruction inst){
		instructions.add(inst);
	}
	
	public String getCommand(){
		return function+parameter;
	}
	
	public ArrayList<Instruction> getInstructions(){
		if(instructions == null){
			instructions = new ArrayList<Instruction>();
			instructions.add(new Instruction(""));
		}
		return instructions;
	}
}
