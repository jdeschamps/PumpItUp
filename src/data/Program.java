package data;

import java.util.ArrayList;
import java.util.Collections;

public class Program {

	private ArrayList<Phase> phases;
	
	public Program(){
		phases = new ArrayList<Phase>();
		phases.add(new Phase());
	}
	
	public Phase getPhase(int i){
		if(i>=0 && i<phases.size()){
			return phases.get(i);
		}
		return null;
	}
	public int getNumberPhases(){
		return phases.size();
	}
	
	public void addPhase(){
		phases.add(new Phase());
	}

	public void removePhase(int i){
		if(i>0){
			phases.remove(i);
		}
	}
	
	public void moveUpPhase(int i){
		if(i>0){
			Collections.swap(phases, i, i-1);
		}
	}
	
	public void moveDownPhase(int i){
		if(i>=0 && phases.size()>1){
			Collections.swap(phases, i, i+1);
		}
	}
	
	public ArrayList<Phase> getPhases(){
		return phases;
	}
	
	public String[] getPhaseList(){
		int i = phases.size();
		String[] def = {"Empty"};
		
		if(i>0){
			String[] s = new String[i];
			
			for(int j=0;j<i;j++){
				s[j] = phases.get(j).getFunction(); 
			}
		}
		
		return def;
	}
}
