<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transactions</title>
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
        <li><a href="Home.jsp"><img alt="" src="logo-1.png"></a></li>
    </ul>
</nav>

<div class="section">
    <div class="sidenav">
        <!--   <a href="Dashboard.jsp">Dashboard </a>-->
        <a href="CustomerInfo">Profile</a>
        <a href="deposit.jsp">Deposits</a>
        <a href="withdraw.jsp">Withdraw</a>
        <a href="transfer.jsp">Transfer</a>
        <a href="PracticeServlet">Transactions</a>
        <a href="Logout">Logout</a>
    </div>

    <div class="main">
         <h1>Transaction Information</h1>

      <c:if test="${not empty transactions}">
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Account Number</th>
                    <th>Type</th>
                    <th>Amount</th>
                    <th>Balance After</th>
                    <th>Date</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="transaction" items="${transactions}">
                    <tr>
                        <td>${transaction.id}</td>
                        <td>${transaction.acc}</td>
                        <td>${transaction.type}</td> <!-- Ensure type is handled as a string -->
                        <td>${transaction.amount}</td>
                        <td>${transaction.balanceAfter}</td>
                        <td>${transaction.date}</td>
                    </tr>
                  <!--  <tr>
                        <td colspan="6">Debug: ${transaction.type}</td>
                    </tr> 
                    -->
                </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${empty transactions}">
        <p>No transactions found.</p>
    </c:if>
    </div>
</div>

</body>
</html>
