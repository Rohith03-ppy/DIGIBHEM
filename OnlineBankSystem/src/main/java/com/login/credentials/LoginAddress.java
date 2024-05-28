package com.login.credentials;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class LoginAddress {
	static String sql = "insert into address(acc, add1, state, add2, zip) values(?,?,?,?,?)";
	static String url = "jdbc:mysql://localhost:3306/sravanthi";
	static String username = "root";
	static String password = "Rohith123#";
	
	public void updateaddress(String acc, String add1, String state, String add2, String zip) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, acc);
			st.setString(2, add1);
			st.setString(3, state);
			st.setString(4, add2);
			st.setString(5, zip);
			
			
			st.executeUpdate();
			
			System.out.println("Address Uploaded Successfully...");
			
			con.close();
		}catch(Exception e) { 
			e.printStackTrace();
		}
	}
}
