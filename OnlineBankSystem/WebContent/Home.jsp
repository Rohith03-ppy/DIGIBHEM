<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
 <link rel = "stylesheet" href = "style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    
</head>
<body>
	 <nav>
	 
	 	<ul>
	        <li><img alt="" src="logo-1.png"></li>
            <li><a href = "Home.jsp">Home</a></li>
            <li><a href = "#services">Services</a></li>
            <li><a href = "login.jsp">NetBanking</a></li>
            <li><a href = "#contact">Contact us</a></li>
        </ul>
    </nav>
    
    
    <div  class = "container">
    	<div class = "content">
    	<h1>Online Banking System</h1>
    	<p id="para">
Welcome to our online banking platform, where convenience meets security, and your financial needs find their perfect digital companion.</p>
    	<p id="para">Experience the freedom of banking on your terms, at your pace, with our online banking system. Join us today and discover a world of convenience, security, and personalized financial solutions tailored to your needs. Welcome to banking made simple.</p>
    	<a href="login.jsp"><button type = "button" >Login</button></a>
    	</div>
    	<div class = "logo">
    	<img alt="" src="logo-1.png">
    	</div>
    
    
    
    </div>
    <section id="services">
		<div class="service-card">
			<h3>Account Management</h3>
			<p>Access your accounts 24/7, check balances, view transaction history, and transfer funds between accounts.</p>
		</div>
	
		<div class="service-card">
			<h3>Bill Payment</h3>
			<p>Pay your bills online securely, set up recurring payments, and receive electronic bills directly through our platform.</p>
		</div>
	
		<div class="service-card">
			<h3>Mobile Banking</h3>
			<p>Manage your finances on the go with our mobile banking app. Check balances, deposit checks, and transfer money from your smartphone or tablet.</p>
		</div>
	</section>
	
	<section id="contact">
        <h2>Contact Us</h2>
        <p>If you have any questions or inquiries, please fill out the form below and we will get back to you as soon as possible.</p>
        <form action="#" method="post">
            <label for="name">Name</label>
            <input type="text" id="name" name="name" required>

            <label for="email">Email</label>
            <input type="email" id="email" name="email" required>

            <label for="subject">Subject</label>
            <input type="text" id="subject" name="subject" required>

            <label for="message">Message</label>
            <textarea id="message" name="message" required></textarea>

            <button type="submit">Submit</button>
        </form>
    </section>
    
    <footer>
		<div class="footer-container">
			<div class="footer-about">
				<h3>About Us</h3>
				<p>We provide secure and reliable online banking services to help you manage your finances efficiently.</p>
			</div>
			<div class="footer-contact">
				<h3>Contact Us</h3>
				<p>Email: support@onlinebanking.com</p>
				<p>Phone: +1 234 567 890</p>
			</div>
			<div class="footer-social">
				<h3>Follow Us</h3>
				<ul>
					<li><a href="#">Facebook</a></li>
					<li><a href="#">Twitter</a></li>
					<li><a href="#">LinkedIn</a></li>
					<li><a href="#">Instagram</a></li>
				</ul>
			</div>
		</div>
		<div class="footer-bottom">
			<p>&copy; 2024 Online Banking. All rights reserved.</p>
		</div>
	</footer>
	
</body>
</html>