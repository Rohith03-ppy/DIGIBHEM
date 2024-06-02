package com.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.credentials.LoginAddress;
import com.login.credentials.LoginCredentialsInsert;
import com.login.credentials.LoginKYC;
import com.login.credentials.LoginPersonalinfo;
import com.login.hashing.PassHashing;


@WebServlet("/Register")
public class Register extends HttpServlet {

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String fathername = request.getParameter("fathername");
		String mothername = request.getParameter("mothername");
		String gender = request.getParameter("gender");
		String dob = request.getParameter("dob");
		String acctype = request.getParameter("acctype");
		
		
		String pan = request.getParameter("pan");
		String adhar = request.getParameter("adhar");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		String add1 = request.getParameter("add1");
		String state = request.getParameter("state");
		String add2 = request.getParameter("add2");
		String zip = request.getParameter("zip");
		
		PassHashing hashing = new PassHashing();
		
		
		LoginCredentialsInsert ins = new LoginCredentialsInsert();
		LoginPersonalinfo info = new LoginPersonalinfo(); 
		LoginKYC kyc = new LoginKYC();
		LoginAddress address = new LoginAddress();
		AccountNumber account = new AccountNumber();
		
		
		if((uname != null && uname != "" ) && (pass != null && pass != "")) {
			String username = hashing.doHashing(uname);
			String password = hashing.doHashing(pass);
			
			String acc = account.generateAccountNumber();
			ins.Update(acc, username, password);
			info.update(acc, fname, lname, fathername, mothername, gender, dob, acctype);
			kyc.updatekyc(acc, pan, adhar, email, phone);
			address.updateaddress(acc, add1, state, add2, zip);
			
			HttpSession session = request.getSession();
			session.setAttribute("username", uname);
			response.sendRedirect("login.jsp");
		}else {
			response.sendRedirect("Error.jsp");
		}
		
		
	}

}
