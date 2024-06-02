<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Deposit</title>
<link rel="stylesheet" href="style1.css">
 <link rel="stylesheet" href="style.css">
  <link rel="stylesheet" href="style2.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">

</head>
<body>

<%
	
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	
	if(session.getAttribute("username") == null){
		response.sendRedirect("login.jsp");
	}
	
	
	%>
	
	 <nav>
	 
	 	<ul>
	       <li><a href = "Home.jsp"><img alt="" src="logo-1.png"></a></li>
           
            
        </ul>
	 
	
        
    </nav>

<div class = "section">
 
 
 
	
	 <div class="sidenav">
	<!--   <a href="Dashboard.jsp">Dashboard </a>-->
    <a href="CustomerInfo">Profile</a>
    <a href="deposit.jsp">Deposits</a>
    <a href="withdraw.jsp">withdraw</a>
    <a href="transfer.jsp">Transfer</a>
    <a href="PracticeServlet">Transactions</a>
   <a href="Logout">Logout</a>
   
   </div>
     
   <div class = "main">
   
   <h2>Deposit Information</h2>
   <form action="CustomerInfo" method="post">
                <input type="hidden" name="action" value="deposit">
                Amount: <input type="number" name="amount" step="0.01" required>
                <button type="submit">Deposit</button>
            </form>

            <c:if test="${not empty error}">
                <p style="color: red;">${error}</p>
            </c:if>
    
   </div>
 
 
 
 </div>

</body>
</html>