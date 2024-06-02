
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
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
	 <a href="Dashboard.jsp">Dashboard </a>
    <a href="CustomerInfo">Profile</a>
    <a href="deposit.jsp">Deposits</a>
    <a href="withdraw.jsp">withdraw</a>
    <a href="transfer.jsp">Transfer</a>
    <a href="transactions.jsp">Transactions</a>
   <a href="Logout">Logout</a>
   
   </div>
     
   <div class = "main">
   
   <h2>Customer Information</h2>
    <c:if test="${not empty customer}">
        <table border="1">
            <tr>
                <th>Balance:</th>
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