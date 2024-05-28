package com.login.credentials;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class LoginPersonalinfo {
	static String sql = "insert into personalinfo(acc, fname, lname, father, mother, gender, dob, acctype) values(?,?,?,?,?,?,?,?)";
	static String url = "jdbc:mysql://localhost:3306/sravanthi";
	static String username = "root";
	static String password = "Rohith123#";
	
	
	public  void update(String acc, String fname, String lname, String father, String mother, String gender, String dob, String acctype) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, acc);
			st.setString(2, fname);
			st.setString(3, lname);
			st.setString(4, father);
			st.setString(5, mother);
			st.setString(6, gender);
			st.setString(7, dob);
			st.setString(8, acctype);
			
			st.executeUpdate();
			
			System.out.println("Uploaded Successfully...");
			
			con.close();
		}catch(Exception e) { 
			e.printStackTrace();
		}
	}
	
}
         