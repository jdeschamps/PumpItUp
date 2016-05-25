package data;

import java.io.Serializable;
import java.util.ArrayList;

public class Phase implements Serializable{
	
	private Function function = Function.STP;
	private String parameter = "";
	private ArrayList<Instruction> instructions;

	public Phase(){
		instructions = new ArrayList<Instruction>();
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
		if(!s.equals(function.getName())){
			function = Function.valueOf(s);
			System.out.println("Clear instructions");
			instructions.clear();
			parameter = "";
		}
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

	public void setInstructions(ArrayList<Instruction> inst){
		instructions = inst;
	}
	
	public String getCommand(){
		return function+parameter;
	}
	
	public String getParameter(){
		return parameter;
	}
	
	public ArrayList<Instruction> getInstructions(){
		if(instructions == null){
			System.out.println("instructions from phase is null");
			instructions = new ArrayList<Instruction>();
			instructions.add(new Instruction("",""));
		}
		return instructions;
	}
	
	public int getNumberInstructions(){
		return instructions.size();
	}
}
