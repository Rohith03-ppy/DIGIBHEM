package com.login.credentials;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class LoginKYC {
	static String sql = "insert into kyc(acc, pan, adhar, email, phone) values(?,?,?,?,?)";
	static String url = "jdbc:mysql://localhost:3306/sravanthi";
	static String username = "root";
	static String password = "Rohith123#";
	
	public void updatekyc(String acc, String pan, String adhar, String email, String phone) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, acc);
			st.setString(2, pan);
			st.setString(3, adhar);
			st.setString(4, email);
			st.setString(5, phone);
			
			
			st.executeUpdate();
			
			System.out.println("KYC Uploaded Successfully...");
			
			con.close();
		}catch(Exception e) { 
			e.printStackTrace();
		}
	}
}
