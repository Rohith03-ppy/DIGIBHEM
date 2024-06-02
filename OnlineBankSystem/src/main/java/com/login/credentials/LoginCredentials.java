package com.login.credentials;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginCredentials {
	
	String sql = "select * from login where acc = ? and uname = ? and pass = ?";
	String url = "jdbc:mysql://localhost:3306/sravanthi";
	String username = "root";
	String password = "Rohith123#";
	
	 public boolean check(String acc, String uname, String pass) {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, acc);
			st.setString(2, uname);
			st.setString(3, pass);
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				return true;
			}
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
}
