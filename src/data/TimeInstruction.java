package data;

public class TimeInstruction extends Instruction{

	private TimeUnit unit;			
	private double time;
	private double rate;
	
	public TimeInstruction(TimeUnit unit, double time, double rate) {
		super("VOL");
		setUnit(unit);
		setTimeValue(time);
		setRate(rate);
	}

	public void setUnit(TimeUnit unit){
		this.unit = unit;
	}
	public void setTimeValue(double time){
		this.time = time;
	}
	public void setRate(double rate){
		this.rate = rate;
	}
	
	public TimeUnit getUnit(){
		return unit;
	}
	public double getTime(){
		return time;
	}
	public double getRate(){
		return rate;
	}
	
	public double getTimeMin(){
		if(unit == TimeUnit.HOUR){
			return time*60;
		} else if(unit == TimeUnit.SEC){
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
