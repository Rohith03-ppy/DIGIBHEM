package com.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/PracticeServlet")
public class PracticeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();
	        String accountNumber = (String) session.getAttribute("accountNumber");

	        if (accountNumber == null) {
	            response.sendRedirect("login.jsp");
	            return;
	        }

	        String url = "jdbc:mysql://localhost:3306/sravanthi";
	        String username = "root";
	        String password = "Rohith123#";
	        List<Transaction> transactions = new ArrayList<>();
	        
	        try {
	        	 Class.forName("com.mysql.cj.jdbc.Driver");
	             Connection con = DriverManager.getConnection(url, username, password);
	             
	          // Fetch transactions
	             String sql4 = "SELECT * FROM transactions WHERE acc = ? ORDER BY date DESC";
	             PreparedStatement statement4 = con.prepareStatement(sql4);
	             statement4.setString(1, accountNumber);
	             ResultSet resultSet4 = statement4.executeQuery();
	             if (resultSet4.next()) {
	                 int id = resultSet4.getInt("id");
	                 String type = resultSet4.getString("type");
	                 double amount = resultSet4.getDouble("amount");
	                 double balanceAfter = resultSet4.getDouble("balance_after");
	                 String date = resultSet4.getTimestamp("date").toString();
	                 transactions.add(new Transaction(id, accountNumber, type, amount, balanceAfter, date));
	             }
	             resultSet4.close();
	             statement4.close();
	        	
	        	
	        }catch(Exception e) {
	        	e.printStackTrace();
	        }
	        
	        // Set transactions attribute for transactions.jsp
	        request.setAttribute("transactions", transactions);

	        // Forward to transactions.jsp
	        request.getRequestDispatcher("/transactions.jsp").forward(request, response);
		
		
		
	}

	
}
