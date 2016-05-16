package data;

import java.io.File;
import saver.ProfileManager;
import mmcorej.CMMCore;

public class Controller {

	private String device = "Aladdin";
	private CMMCore core;
	private Profile profile;
	private ProfileManager manager;
	
	private static String run = "Run Pump";
	
	
	public Controller(CMMCore core){
		this.core = core;
		profile = new Profile();
		manager = new ProfileManager();
	}
	
	//////////////////////////////////////// Pumps
	public void emptyPumps(){
		profile.emptyPumps();
	}
	
	public void addPump(){
		profile.addPump();
	}
	
	public void removePump(int i){
		profile.removePump(i);
	}
	
	public String[] getPumpList(){
		return profile.getPumpList();
	}

	public int getNumberPumps(){
		return profile.getNumberPumps();
	}

	public Pump getPump(int selectedIndex) {
		return profile.getPump(selectedIndex);
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

	public void saveCurrentProfile(){
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
			core.setProperty(device, property, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setProperty(String property, int value){
		try {
			core.setProperty(device, property, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void startPumps(){
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
