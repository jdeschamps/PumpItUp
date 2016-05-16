package data;

import java.io.Serializable;
import java.util.ArrayList;

public class Profile implements Serializable{

	private String name;
	private ArrayList<Pump> pumps;

	public Profile(){
		this.name = "Unnamed";
		this.pumps = new ArrayList<Pump>();
		pumps.add(new Pump(0));
	}

	public Profile(String name){
		this.name = name;
		this.pumps = new ArrayList<Pump>();
		pumps.add(new Pump(0));
	}
	
	public Profile(String name, ArrayList<Pump> pumps){
		this.name = name;
		this.pumps = pumps;
	}
	
	public String getName(){
		return name;
	}
	
	public ArrayList<Pump> getPumps(){
		if(pumps == null){
			pumps = new ArrayList<Pump>();
			pumps.add(new Pump(0));
		}
		return pumps;
	}
	
	public Pump getPump(int i){
		if(i>=0 && i<getNumberPumps()){
			return pumps.get(i);	
		} 
		return null;
	}
	
	public void setName(String s){
		this.name = name;
	}
	
	public int getNumberPumps(){
		return pumps.size();
	}
	
	public void emptyPumps(){
		pumps.clear();
		pumps.add(new Pump(0));
	}
	
	public String[] getPumpList(){
		int n = getNumberPumps();
		String[] def = {"Empty"};
		
		if(n>0){
			String[] s = new String[n];
			
			for(int j=0;j<n;j++){
				s[j] = pumps.get(j).getName(); 
			}
			return s;
		}
		
		return def;
	}

	public void addPump(){
		pumps.add(new Pump(0));
	}
	
	public void removePump(int i){
		if(getNumberPumps()>1){
			pumps.remove(i);
		} else {
			emptyPumps();
		}
	}
	
	public boolean hasPump(int index){
		return (index >=0 && index<getNumberPumps());
	}
	
	public boolean hasPhase(int pumpind, int phaseind){
		if(hasPump(pumpind)){
			Pump p = pumps.get(pumpind);
			return (phaseind>=0 && phaseind<p.getNumberPhases());
		}
		return false;
	}
}
