package data;

import java.io.File;
import java.util.ArrayList;

import saver.ProfileManager;
import mmcorej.CMMCore;

public class Controller {

	private String device = "Aladdin";
	private ArrayList<Pump> pumps;
	private CMMCore core;
	private Profile profile;
	private ProfileManager manager;
	
	private static String run = "Run Pump";
	
	
	public Controller(CMMCore core){
		this.core = core;
		pumps = new ArrayList<Pump>();
		manager = new ProfileManager();
	}
	
	//////////////////////////////////////// Pumps
	public void emptyPumps(){
		pumps.clear();
		pumps.add(new Pump());
	}
	
	public void addPump(){
		pumps.add(new Pump());
	}
	
	public void removePump(int i){
		pumps.remove(i);
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

	public int getNumberPumps(){
		return pumps.size();
	}

	public Pump getPump(int selectedIndex) {
		if(selectedIndex<0 || selectedIndex>= getNumberPumps()){
			return null;
		}
		return pumps.get(selectedIndex);
	}
	
	///////////////////////////////////////// Profile
	public void setCurrentProfile(Profile profile){
		this.profile = profile;
		pumps = profile.getPumps();
	}
	
	public void setCurrentProfile(int i){
		this.profile = manager.getProfile(i);
		pumps = profile.getPumps();
	}
	
	public Profile getCurrentProfile(){
		if(profile == null){
			generateProfile("");
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
		profile = new Profile(name, pumps);
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
			setProperty(run+pumps.get(i).getAddress(), 1);
		}
	}

	public void stopPumps(){
		for(int i=0;i<getNumberPumps();i++){
			setProperty(run+pumps.get(i).getAddress(), 0);
		}
	}
}
