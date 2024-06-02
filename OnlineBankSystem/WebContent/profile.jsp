<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
<link rel="stylesheet" href="style1.css">
 <link rel="stylesheet" href="style.css">
 <link rel="stylesheet" href="style2.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">

</head>
<body>

<%
	
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	
	if(session.getAttribute("username") == null ){
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
   
   <h2>Customer Information</h2>
   
 
   
   
   
     <c:if test="${not empty customer}">
        <table border="1">
            <tr>
                <th>Account Number</th>
                <td>${customer.accountNumber}</td>
    
            </tr>
            <tr>
                <th>First Name</th>
                <td>${customer.firstname}</td>
            </tr>
            <tr>
                <th>Last Name</th>
                <td>${customer.lastname}</td>
            </tr>
            <tr>
                <th>Father Name</th>
                <td>${customer.fathername}</td>
            </tr>
            <tr>
                <th>Mother Name</th>
                <td>${customer.mothername}</td>
            </tr>
            <tr>
                <th>Gender</th>
                <td>${customer.gender}</td>
            </tr>
            <tr>
                <th>Date of Birth</th>
                <td>${customer.dob}</td>
            </tr>
            <tr>
                <th>Account type</th>
                <td>${customer.acctype}</td>
            </tr>
            <tr>
                <th>PAN Number</th>
                <td>${address.pan}</td>
            </tr>
            <tr>
                <th>Adhar Number</th>
                <td>${address.adhar}</td>
            </tr>
            <tr>
                <th>Email</th>
                <td>${address.email}</td>
            </tr>
            <tr>
                <th>Mobile Number</th>
                <td>${address.phone}</td>
            </tr>
            <tr>
                <th>Address 1</th>
                <td>${cusaddress.add1}</td>
            </tr>
            <tr>
                <th>State</th>
                <td>${cusaddress.state}</td>
            </tr>
            <tr>
                <th>Address 2</th>
                <td>${cusaddress.add2}</td>
            </tr>
            <tr>
                <th>Pin code</th>
                <td>${cusaddress.zip}</td>
            </tr>
            
            
            <tr>
                <th>Balance</th>
                <td>${customer.balance}</td>
            </tr>
            
           
            
            
            
            
                
        </table>
    </c:if>
    <c:if test="${empty customer}">
        <p>No customer found with the provided account number.</p>
    </c:if>
    
    
   
   </div>
   
    

 
 
 
 
 
 
 
 
 
 
 </div>



</body>
</html>