package saver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.sun.org.apache.xml.internal.utils.NSInfo;

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
		System.out.println("found "+files.length+" profiles");
		for(int i=0;i<files.length;i++){
			System.out.println("read "+files[i].getName());
			readProfile(files[i].getPath());
		}
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
				String profilename = profiles.get(j).getName();
				if(profilename.contains(".piuprofile")){
					s[j] = profilename.substring(0, profilename.length()-11);
				} else {
					s[j] = profilename; 
				}
			}
			return s;
		}
		
		return def;
	}
	
	public Profile getProfile(int i){
		if(i>=0 && i<profiles.size()){
			return profiles.get(i);
		}
		return null;
	}
	
	public void saveProfile(File f, Profile p){
		try {
			FileOutputStream f_out = new FileOutputStream(f);
		  	ObjectOutputStream obj_out;

			obj_out = new ObjectOutputStream (f_out);
			
			obj_out.writeObject (p);

			obj_out.close();
			
			//reload();
			if(!profiles.contains(p)){
				profiles.add(p);
			}
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
				System.out.println("Add profile "+((Profile) obj).getName());
				profiles.add((Profile) obj);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void reload(){
		profiles.clear();
		searchProfiles();
	}
}
