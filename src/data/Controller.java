package data;

import java.io.File;
import saver.ProfileManager;
import mmcorej.CMMCore;

public class Controller {

	private String device = "Aladdin";
	private CMMCore core;
	private Profile profile;
	private ProfileManager manager;
	private int currentPump = 0;
	private int currentPhase = 0;
	
	private static String run = "Run Pump";
	
	
	public Controller(CMMCore core){
		this.core = core;
		profile = new Profile();
		manager = new ProfileManager();
	}
	
	//////////////////////////////////////// Pumps
	public void setCurrentPump(int i){
		if(hasPump(i)){
			currentPump = i;
		}
	}

	public int getCurrentPumpNumber(){
		return currentPump;
	}

	public void addPump(){
		profile.addPump();
	}
	
	public void removePump(){
		if(currentPump!=getNumberPumps()-1){
			profile.removePump(currentPump);
		} else {
			profile.removePump(currentPump);
			currentPump=getNumberPumps()-1;
		}
	}
	
	public String[] getPumpList(){
		return profile.getPumpList();
	}
	
	public int getNumberPumps(){
		return profile.getNumberPumps();
	}
	
	public boolean hasPump(int index){
		return profile.hasPump(index);
	}


	////////////////////////////////////// pumps internal use
	private Pump getPump(int i){
		return profile.getPump(i);
	}

	private Phase getPhase(int i, int j){
		return profile.getPump(i).getPhase(j);
	}
	
	/////////////////// change current pump
	public void setPumpName(String name){
		profile.getPump(currentPump).setName(name);
	}

	public String getPumpName(){
		return profile.getPump(currentPump).getName();
	}

	public void setPumpDiameter(int diameter){
		profile.getPump(currentPump).setDiameter(diameter);
	}

	public int getPumpDiameter(){
		return profile.getPump(currentPump).getDiameter();
	}

	public void setPumpAddress(int address){
		profile.getPump(currentPump).setAddress(address);
	}

	public int getPumpAddress(){
		return profile.getPump(currentPump).getAddress();
	}
	
	////////////////////////////// phases
	public void setFunction(String function){
		profile.getPump(currentPump).getPhase(currentPhase).setFunction(function);
	}
	
	public void setCurrentPhase(int i){
		if(hasPhase(currentPump, i)){
			currentPhase = i;
		}
	}

	public int getCurrentPhaseNumber(){
		return currentPhase;
	}
	

	public Phase getCurrentPhase(){
		return profile.getPump(currentPump).getPhase(currentPhase);
	}

	public String getPhaseFunction(){
		return profile.getPump(currentPump).getPhase(currentPhase).getFunction();
	}
	
	public int getNumberPhases(){
		return profile.getPump(currentPump).getNumberPhases();
	}
	public boolean hasPhase(int pumpind, int phaseind){
		return profile.hasPhase(pumpind, phaseind);
	}

	public String[] getPhaseList(){
		return profile.getPump(currentPump).getPhaseList();
	}
	
	private int getNumberPhases(int i){
		return profile.getPump(i).getNumberPhases();
	}
	
	
	///// change current phase
	public void removePhase(){
		if(getNumberPhases()>0){
			if(currentPhase!=getNumberPhases()-1){
				profile.getPump(currentPump).removePhase(currentPhase);
			} else {
				profile.getPump(currentPump).removePhase(currentPhase);
				currentPhase = getNumberPhases()-1;
			}
		}
	}

	public void addPhase(){
		profile.getPump(currentPump).addPhase();
	}
	
	public void movePhaseUp(){
		if(currentPhase>0){
			profile.getPump(currentPump).moveUpPhase(currentPhase);
		}
	}
	
	public void movePhaseDown(){
		if(currentPhase<getNumberPhases()-1){
			profile.getPump(currentPump).moveDownPhase(currentPhase);
		}
	}
	
	///////////////////////////////////////// Profile
	public void setCurrentProfile(Profile profile){
		this.profile = profile;
	}
	
	public void setCurrentProfile(int i){
		this.profile = manager.getProfile(i);
	}
	
	public Profile getCurrentProfile(){
		if(profile == null){
			generateProfile("New");
		}
		return profile;
	}

	public void saveCurrentProfile(String s){
		profile.setName(s);
		manager.saveProfile(profile);
	}
	
	public int getNumberProfiles(){
		return manager.getNumberProfiles();
	}
	
	public void generateProfile(String name){
		profile = new Profile(name);
	}
	
	public Profile getProfileFromList(int i){
		setCurrentProfile(i);
		return profile;
	}
	
	public String[] getStringProfiles(){
		return manager.getStringProfiles();
	}

	public void loadNewProfile(File selectedFile) {
		manager.readProfile(selectedFile.getAbsolutePath());
	}

	
	////////////////////////////////////////////////// Controls
	public void setProperty(String property, String value){
		try {
			//core.setProperty(device, property, value);
			System.out.println(property+" "+value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setProperty(String property, int value){
		try {
			//core.setProperty(device, property, value);
			System.out.println(property+" "+value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setPhase(int i, Pump p, Phase ph){
		setProperty("Phase Pump"+p.getAddress(),i);
		setProperty("Function Pump"+p.getAddress(),"FUN"+ph.getCommand());
		for(int j=0;j<ph.getNumberInstructions();j++){
			setProperty(ph.getInstructions().get(j).getCommand()+" Pump"+p.getAddress(),ph.getInstructions().get(j).getParameter());
		}
	}
	
	public void startPumps(){
		// send program
		for(int i=0;i<getNumberPumps();i++){
			for(int j=0;j<getNumberPhases(i);j++){
				setPhase(j, getPump(i),getPhase(i,j));
			}
		}
		
		for(int i=0;i<getNumberPumps();i++){
			setProperty(run+getPump(i).getAddress(), 1);
		}
	}

	public void stopPumps(){
		for(int i=0;i<getNumberPumps();i++){
			setProperty(run+getPump(i).getAddress(), 0);
		}
	}
}
