package com.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.credentials.LoginCredentials;
import com.login.hashing.PassHashing;



@WebServlet("/Login")
public class Login extends HttpServlet {
	
	 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accountNumber = request.getParameter("accountNumber");
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		
		LoginCredentials dao = new LoginCredentials();
		
		
		PassHashing hashing = new PassHashing();
		String username = hashing.doHashing(uname);
		String password = hashing.doHashing(pass);
		
		if(dao.check(accountNumber, username, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("username", uname);
			session.setAttribute("accountNumber", accountNumber);
			response.sendRedirect("CustomerInfo");
//			response.sendRedirect("Dashboard.jsp");
		}else {
			response.sendRedirect("login.jsp");
		}
	}

}
