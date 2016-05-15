package saver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import data.Profile;

public class ProfileManager {
	
	private ArrayList<Profile> profiles;
	
	public ProfileManager(){
		profiles = new ArrayList<Profile>();
		searchProfiles();
	}
	
	public void searchProfiles(){
		File dir = new File(System.getProperty("user.dir")+"/PIU_profiles");
		File[] files = dir.listFiles(new FilenameFilter() {
		    public boolean accept(File dir, String name) {
		        return name.toLowerCase().endsWith(".piuprofile");
		    }
		});	
	}
	
	public void addProfile(Profile p){
		profiles.add(p);
	}
	
	public int getNumberProfiles(){
		return profiles.size();
	}
	
	public String[] getStringProfiles(){
		int i = profiles.size();
		String[] def = {"Empty"};
		
		if(i>0){
			String[] s = new String[i];
			
			for(int j=0;j<i;j++){
				s[j] = profiles.get(j).getName(); 
			}
		}
		
		return def;
	}
	
	public Profile getProfile(int i){
		return profiles.get(i);
	}
	
	public void saveProfile(Profile p){
		try {
			FileOutputStream f_out = new FileOutputStream(System.getProperty("user.dir")+"/PIU_profiles/"+p.getName()+".piuprofile");
			ObjectOutputStream obj_out;

			obj_out = new ObjectOutputStream (f_out);
			
			obj_out.writeObject (p);

			obj_out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readProfile(String path){
		try {
			Object obj;
			FileInputStream f_in;
			f_in = new FileInputStream(path);
			
			ObjectInputStream obj_in;
			obj_in = new ObjectInputStream (f_in);

			obj = obj_in.readObject();

			obj_in.close();
			
			if (obj instanceof Profile){
				profiles.add((Profile) obj);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
