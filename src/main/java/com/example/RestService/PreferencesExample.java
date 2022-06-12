package com.example.RestService;
import java.io.*;
import java.util.*;
import java.util.prefs.Preferences;

public class PreferencesExample {

    public static void main(String args[]) throws FileNotFoundException {
        Preferences ps = Preferences.userNodeForPackage(PreferencesExample.class);
        // Load  file object
        System.getProperty("user.dir");
        
        	// if you cannot find data.xml file, try this and see what files are in your directory
//        File file = new File(".");
//        for(String fileNames : file.list()) System.out.println(fileNames);
        
        File fileObj = new File("data.xml");
        try {
            FileInputStream fis = new FileInputStream(fileObj);
            ps.importPreferences(fis);
            
            System.out.println("Get property1:"+ps.get("username","10"));
            System.out.println("Get property1:"+ps.get("password","10"));

        } catch (Exception err) {
            err.printStackTrace();
        }
    }
}