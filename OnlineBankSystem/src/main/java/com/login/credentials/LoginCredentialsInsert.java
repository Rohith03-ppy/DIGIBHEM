package com.login.credentials;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class LoginCredentialsInsert {

	
	String sql = "insert into login(acc, uname, pass) values(?,?,?)";
	String url = "jdbc:mysql://localhost:3306/sravanthi";
	String username = "root";
	String password = "Rohith123#";
	
	public void Update(String acc,String uname, String pass) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, acc);
			st.setString(2, uname);
			st.setString(3,pass);
			
			st.executeUpdate();
			
			System.out.println("Inserted Successfully");
			
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
