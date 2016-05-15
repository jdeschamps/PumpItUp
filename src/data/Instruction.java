package data;

public class Instruction {

	protected String command;
	protected String param;
	
	public Instruction(String command, String param){
		this.command = command;
		this.param = param;
	}
	
	public void setParameter(String param){
		this.param = param;
	}
	
	public String getParameter(){
		return param;
	}
	
	public String getCommand(){
		return command+param;
	}
}

