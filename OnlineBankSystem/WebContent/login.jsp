<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>
<link rel = "stylesheet" href = "form.css">
</head>
<body>
    <form action="Login" method="post">
        <label for="accountNumber">Enter Account Number:</label>
        <input type="tel" id="accountNumber" name="accountNumber" required ><br>

        <label for="uname">Enter Username:</label>
        <input type="text" id="uname" name="uname" required><br>

        <label for="pass">Enter Password:</label>
        <input type="password" id="pass" name="pass" required><br>

        <input type="submit" value="Login"><br>
        
        <div class="create-account">
            Do not have an account? <a href="create.jsp">Create</a>
        </div>
    </form>
</body>
</html>