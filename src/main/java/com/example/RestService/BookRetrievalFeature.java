package com.example.RestService;

import java.sql.*;
import java.io.*;
import java.util.*;
import java.util.prefs.Preferences;

import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Cache.Connection;

public class BookRetrievalFeature {
	public String returnData = "";
	private String query;
	private Statement stm;
	private String username;
	private String password;
	private String host;
	
	public BookRetrievalFeature(String query) {
		
		host = "jdbc:mysql://l3xksr51tlfz.us-east-2.psdb.cloud/bookshop";
		username = "8fp719dqvuym";
		password = "pscale_pw_ZwC2j7JNZdAf7YBlOnesCEB3ErplyJrMaRJyzgZRF9U";
		try {
			java.sql.Connection connection = DriverManager.getConnection(
					  host,
					  username,
					  password);
			
			this.query = query;
			this.stm = ((java.sql.Connection) connection).createStatement();
			ResultSet rs = stm.executeQuery(this.query);
			
			//display results
			while(rs.next()) {
				
				long isbn = rs.getLong("ISBN");
				String name = rs.getString("Name");
				String desc = rs.getString("Description");
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
						+ " Author: %s<br>"
						+ " Genre: %s<br>"
						+ " Publisher: %s<br>"
						+ "Year Published: %s<br>"
						+ " Copies Sold: %s<br>",
						isbn, name, desc, price, author, genre, publisher, year_published, copies_sold);
			}
		} 
		
		catch (SQLException e) {
			System.out.println("Something went wrong");
			e.printStackTrace();
		}
	}
}
