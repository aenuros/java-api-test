package com.example.RestService;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.util.prefs.Preferences;

import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Cache.Connection;

public class sqlData {
	String returnData = "";
	private String query;
	private Statement stm;
	private String username;
	private String password;
	private String host;
	
	public sqlData(String query) {
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
				
				int isbn = rs.getInt("ISBN");
				String name = rs.getString("Name");
				String desc = rs.getString("Desc");
				double price = rs.getDouble("Price");
				String author = rs.getString("Author");
				String genre = rs.getString("Genre");
				String publisher = rs.getString("Publisher");
				int year_published = rs.getInt("Year_Published");
				int copies_sold = rs.getInt("Copies_Sold");
				
				returnData = returnData + "<br>" + String.format("ISBN: %s<br>"
						+ " Name: %s<br>"
						+ " Description: %s<br>"
						+ " Price: %s<br>"
						+ " Author; %s<br>"
						+ " Genre: %s<br>"
						+ " Publisher: %s<br>"
						+ "Year Published: %s<br>"
						+ " Copies Sold: %s<br>",
						isbn, name, desc, price, author, genre, publisher, year_published, copies_sold
						);
			}
			
		} 
		
		catch (SQLException e) {
			System.out.println("Something went wrong");
			e.printStackTrace();
		}
	}
}
