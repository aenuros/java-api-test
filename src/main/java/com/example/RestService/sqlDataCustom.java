package com.example.RestService;
import java.sql.*;
import java.sql.Date;
import java.io.*;
import java.util.*;
import java.util.prefs.Preferences;

import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Cache.Connection;

public class sqlDataCustom {
	String returnData = "<p><a href=\"/home\">Return to home</a></p>";
	private String query;
	private Statement stm;
	private String username;
	private String password;
	private String host;

	public sqlDataCustom(String query) {
        Preferences ps = Preferences.userNodeForPackage(PreferencesExample.class);
        // Load  file object
        System.getProperty("user.dir");
        
// if you cannot find data.xml file, try this and see what files are in your directory, then put data.xml in that directory.
//        File file = new File(".");
//        for(String fileNames : file.list()) System.out.println(fileNames);
        
        File fileObj = new File("data.xml");
        try {
            FileInputStream fis = new FileInputStream(fileObj);
            ps.importPreferences(fis);
            
            System.out.println("Get host:"+ps.get("host","10"));
            System.out.println("Get username:"+ps.get("username","10"));
            System.out.println("Get password:"+ps.get("password","10"));
            
            host = ps.get("host", "DEFAULT");
            username = ps.get("username","DEFAULT");
            password = ps.get("password","DEFAULT");

        } catch (Exception err) {
            err.printStackTrace();
        }
		try {
			java.sql.Connection connection = DriverManager.getConnection(
					  host,
					  username,
					  password);
			
			System.out.println("Connected with the Database Successfully");
			this.query = query;
			this.stm = ((java.sql.Connection) connection).createStatement();
			ResultSet rs = stm.executeQuery(this.query);
			
			//display results
			
			while(rs.next()) {
				
				int stars = rs.getInt("stars");
				
				String starRating;
				
				if (stars == 0) {
					starRating = "No Rating Applied";
				} else {
					starRating = String.valueOf(stars);
				}
				
				String comment = rs.getString("comment");
				
				String commentFull;
				if (comment == null || comment.isEmpty()) {
					commentFull = "User did not leave a comment.";
				} else {
					commentFull = comment;
				}
				
				String name = rs.getString("Name");
				String username = rs.getString("username");
				Date datetime = rs.getDate("datetime");
				
				returnData = returnData + "<br>" + String.format(
						"Name: %s<br>"
						+ " Star rating: %s<br>"
						+ " comment: %s<br>"
						+ " Rated by: %s<br>"
						+ " Published on: %s<br>",
						name, starRating, commentFull, username, datetime
						);
			}
			
		} 
		
		catch (SQLException e) {
			System.out.println("Something went wrong");
			e.printStackTrace();
			
		}
	}
}