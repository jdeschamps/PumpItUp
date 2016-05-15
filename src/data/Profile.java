package data;

import java.io.Serializable;
import java.util.ArrayList;

public class Profile implements Serializable{

	private String name;
	private ArrayList<Pump> pumps;

	public Profile(){
		this.name = "Empty";
		this.pumps = new ArrayList<Pump>();
		pumps.add(new Pump(0));
	}
	
	public Profile(String name, ArrayList<Pump> pumps){
		this.name = name;
		this.pumps = pumps;
	}
	
	public ArrayList<Pump> getPumps(){
		return pumps;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String s){
		this.name = name;
	}
	
	public int getNumberPumps(){
		return pumps.size();
	}
	
	public String[] getPumpList(){
		int i = pumps.size();
		String[] def = {"Empty"};
		
		if(i>0){
			String[] s = new String[i];
			
			for(int j=0;j<i;j++){
				s[j] = pumps.get(j).getName(); 
			}
		}
		
		return def;
	}
}
