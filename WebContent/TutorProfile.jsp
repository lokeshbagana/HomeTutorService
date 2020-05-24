<%@page import="tutor.TutorDetail"%>
<%@page import="Dao.TutorDao"%>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width">
<meta name="description"
	content="Affordable and professional web design">
<meta name="keywords"
	content="web design, affordable web design, professional web design">
<meta name="author" content="Brad Traversy">
<link rel="stylesheet" type="text/css" href="./CSS/Page_Footer.css">
<link rel="stylesheet" type="text/css" href="./CSS/profile.css">

<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://www.w3schools.com/lib/w3-theme-blue-grey.css">
<link rel='stylesheet'
	href='https://fonts.googleapis.com/css?family=Open+Sans'>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
html, body, h1, h2, h3, h4, h5 {
	font-family: "Open Sans", sans-serif
}
</style>
</head>
<body>
<html>
<head>

<title>Online Home-tutor Sevice</title>
<meta name="viewport" content="width-device-width">
<meta name="description"
	content="Affordable and proffessional web design">
<meta name="keywords"
	content="web design,affordable web design, proffessional web design">
<meta name="author" content="sandeep mishra">
<link rel="stylesheet" type="text/css" href="./css/Page_Footer.css">
<link rel="stylesheet" type="text/css" href="./css/bodystyle.css">
<link rel="stylesheet" type="text/css" href="./css/dropdownstyle.css">
<link rel="stylesheet" type="text/css" href="./CSS/profile_css.css">

<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous">
	
</script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous">
	
</script>
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://www.w3schools.com/lib/w3-theme-blue-grey.css">
<link rel='stylesheet'
	href='https://fonts.googleapis.com/css?family=Open+Sans'>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

<style>
html, body, h1, h2, h3, h4, h5 {
	font-family: "Open Sans", sans-serif
}
</style>
</head>
<body>
	<header>
		<div class="container">
			<div id="branding">
				<h1>
					<span class="highlight">Home</span>-tutor Service
				</h1>
			</div>
			<nav>
				<ul>
					<li class="current"><a href="home.html" target="_blank">Home</a></li>
					<li><a href="about.html" target="_blank">About</a></li>
					<li><a href="services.html" target="_blank">Service</a></li>
					<li><a href="footer.html" target="_blank">Contact us</a></li>
					<li>
						<%
							String name = (String) session.getAttribute("email");
							out.print(name);
						%>
					</li>
					<li><a href="#" class="signup-btn" target="_blank"><span>Logout</span></a></li>
				</ul>
			</nav>
		</div>
	</header>
	<div class="row">
		<div class="left">
			<div class="card" style="width: 400px">
				<img class="card-img-top" src="./images/sandeep.jpg"
					alt="Card image">
				<div class="card-body">

					<table class="table table-striped table-hover">

						<thead>
						<tr><td>Profile</td></tr>
						</thead>
						<tbody>
							<%
								try {
									 TutorDao dao = new TutorDao();
			                            ArrayList<TutorDetail> lst = dao.tutorProfile(name);

			                            for (TutorDetail s : lst) {
							%>

							<td>
							<tr>
								<td>Id</td>
								<td><%=s.getTid()%></td>
							</tr>
							<tr>
								<td>Name</td>
								<td><%=s.getName()%></td>
							</tr>
							<tr>
								<td>Email</td>
								<td><%=s.getEmail()%></td>
							</tr>
							<tr>
								<td>Mobile</td>
								<td><%=s.getMobile()%></td>
							</tr>
							<tr>
								<td>Gender</td>
								<td><%=s.getGender()%></td>
							</tr>
							<tr>
								<td>Address</td>
								<td><%=s.getAddress()%></td>
							</tr>
							</td>
							<%
								}
								} catch (Exception e) {

								}
							%>

						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="right">
			<section class="header-section">
				<div class="center-div">
					<h1 class="font-weight-bold">We are the developers</h1>
					<p>we create the world class best Website</p>
					<div class="header-buttons">
						<br /> <a href="" onclick="alert()">FIND-TUTOR</a> <a href=""
							onclick="alert()">ATTENDANCE</a>
					</div>
				</div>
			</section>
		</div>
	</div>


	<section id="newsletter">
		<div class="container">
			<h1 class="h1">Subscribe to our Newsletter</h1>
			<form>
				<input type="email" placeholder="Enter Email...." required>
				<button type="button" class="button_1">Subscribe</button>
			</form>
		</div>
	</section>


	<div class="footer">
		<div class="inner-footer">

			<div class="footer-items">
				<h1>ABOUT US</h1>
				<p>We are one of the renowned and trusted organizations engaged
					in home tuition service in bhopal</p>
			</div>

			<div class="footer-items">
				<h2>Quick Links</h2>
				<div class="border"></div>
				<ul>
					<a href="home.html"><li>Home</li></a>
					<a href="about.html"><li>ABOUT</li></a>
					<a href="service.html"><li>SERVICES</li></a>
					<a href="footer.html"><li>CONTACT US</li></a>
				</ul>
			</div>

			<div class="footer-items">
				<h2>Services</h2>
				<div class="border"></div>
				<ul>
					<a href="refund&cancel.html"><li>REFUND & CANCELLATION</li></a>
					<a href="terms&condition.html"><li>TERMS & CONDITION</li></a>
					<a href=""><li>FIND YOUR BEST HOME-TUTOR</li></a>
					<a href=""><li>OPPORTUNITIES</li></a>

				</ul>
			</div>

			<div class="footer-items">
				<h2>Contact Us</h2>
				<div class="border"></div>
				<ul>
					<li><i class="fa fa-map-marker" aria-hidden="true"></i> 01,
						Vaishali Nagar, Bhopal</li>
					<li><i class="fa fa-phone" aria-hidden="true"></i>9691955555</li>
					<li><i class="fa fa-envelope" aria-hidden="true"></i>support@Hometutorservice.com</li>
				</ul>
				<div class="social-media">
					<a href=""><i class="fa fa-facebook" aria-hidden="true"></i></a> <a
						href=""><i class="fa fa-twitter" aria-hidden="true"></i></a> <a
						href=""><i class="fa fa-instagram" aria-hidden="true"></i></a> <a
						href=""><i class="fa fa-google-plus" aria-hidden="true"></i></a>
				</div>
			</div>

		</div>
		<footer class="footer-bottom">
			<p>Copyright &copy; 2019 Home Tutor Service | Created by Sandeep
				& Lokesh</p>
		</footer>
	</div>

</body>
</html> 