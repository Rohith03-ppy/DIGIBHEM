<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create</title>
<link rel="stylesheet" href="createform.css">
</head>
<body>
<h2>Account Registration Form</h2>



	<form action = "Register" method = "post">
	<h3>Personal Information</h3>
	
	<label>First Name </label>
	<input type= "text" name = "fname" autofocus required>
	<label>Last Name </label>
	<input type = "text" name = "lname" required><br>
	
	
	
	<label>Father Name: </label>
	<input type= "text" name = "fathername" required>
	<label>Mother Name: </label>
	<input type = "text" name = "mothername" required><br>
	
	
	
	<label>Gender </label>
	<select name="gender" required >
  <option value="Male">Male</option>
  <option value="Female">Female</option>
</select>
	<label>Date of Birth </label>
	<input type = "date" name = "dob" required><br>
	
	
	
	
	<label>Account Type </label>
	<select name="acctype" required >
  <option value="Savings">Savings</option>
  <option value="Current">Current</option>
</select>
	<label>Upload Photo </label>
	<input type = "file" name = "pic" required><br>
	
	
	
	<label>User Name </label>
	<input type = "text" name = "uname">
	<label>Password </label>
	<input type = "password"  name = "pass"><br>
	 
	 
	
	 
	<h3>KYC Details</h3>
	
	<label>PAN Card Number </label>
	<input type= "text" name = "pan" pattern="[a-zA-Z0-9]+" required>
	<label>Adhar Number </label>
	<input type = "tel" name = "adhar" pattern = "[0-9]{12}" required><br>
	 
	 
	 
	 <label>Email id </label>
	  <input type = "email" name = "email" required>
	  <label>Mobile Number </label>
	 <input type = "tel" name = "phone" pattern = "[0-9]{10}" required><br>
	 
	 
	 
	 <h3>Address</h3>
	 
	 <label>Address 1 </label>
	 <textarea name = "add1" rows="3" cols="22" required></textarea>
	<label>State </label>
	<input type = "text" name = "state" required><br>
	
	
	
	<label>Address 2 </label>
	 <textarea name = "add2" rows="3" cols="22"></textarea>
	<label>Post code </label>
	<input type = "text" name = "zip" required><br>
	
	 
	 
	
	
	<input type = "submit" value = "submit"> <br>
	</form>
</body>
</html>