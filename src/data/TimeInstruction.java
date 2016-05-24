package data;

import java.io.Serializable;

public class TimeInstruction extends Instruction  implements Serializable{

	private InstructionTimeUnit unit;			
	private double time;
	private double rate;
	
	public TimeInstruction(InstructionTimeUnit unit, double time, double rate) {
		super("VOL","");
		setUnit(unit);
		setTimeValue(time);
		setRate(rate);
	}

	public void setUnit(InstructionTimeUnit unit){
		this.unit = unit;
	}
	public void setTimeValue(double time){
		this.time = time;
	}
	public void setRate(double rate){
		this.rate = rate;
	}
	
	public InstructionTimeUnit getUnit(){
		return unit;
	}
	public double getTime(){
		return time;
	}
	public double getRate(){
		return rate;
	}
	
	public double getTimeMin(){
		if(unit == InstructionTimeUnit.HOUR){
			return time*60;
		} else if(unit == InstructionTimeUnit.SEC){
			return time/60;
		}
		return time;
	}
	public double getVolume(){
		return rate*getTimeMin();
	}
	@Override
	public String getCommand(){
		return command+getVolume();
	}
}
