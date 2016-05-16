package data;

import java.io.Serializable;
import java.util.ArrayList;

public class Profile implements Serializable{

	private String name;
	private ArrayList<Pump> pumps;

	public Profile(){
		this.name = "Unnamed";
		this.pumps = new ArrayList<Pump>();
		pumps.add(new Pump());
	}

	public Profile(String name){
		this.name = name;
		this.pumps = new ArrayList<Pump>();
		pumps.add(new Pump());
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
			pumps.add(new Pump());
		}
		return pumps;
	}
	
	public Pump getPump(int i){
		if(i>=0 && i<getNumberPumps()){
			return pumps.get(i);	
		} 
		return null;
	}
	
	public int getNumberPumps(){
		return pumps.size();
	}
	
	public void emptyPumps(){
		pumps.clear();
		pumps.add(new Pump());
	}
	
	public String[] getPumpList(){
		int i = getNumberPumps();
		String[] def = {"Empty"};
		
		if(i>0){
			String[] s = new String[i];
			
			for(int j=0;j<i;j++){
				s[j] = pumps.get(j).getName(); 
			}
		}
		
		return def;
	}

	public void addPump(){
		pumps.add(new Pump());
	}
	
	public void removePump(int i){
		if(getNumberPumps()>1){
			pumps.remove(i);
		} else {
			emptyPumps();
		}
	}
	
}
