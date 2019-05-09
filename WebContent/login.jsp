<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="style/style.css" type="text/css">
<link href="css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<script src="js/jquery.validate.min.js"></script>
<link href="css/KaushanScript.css" rel="stylesheet">
<link href="css/font-awesome.min.css" rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Login</title>
<style>
body {
	padding-top: 4.2rem;
	padding-bottom: 4.2rem;
	background-image: url("image/background.png");
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: 1400px 800px;
	background-opacity: 0.2;
}

h1 {
	font-family: 'Kaushan Script', cursive;
}

.myform {
	padding: 1rem;
	width: 100%;
	background-color: #fff;
	background-clip: padding-box;
	border: 1px solid rgba(0, 0, 0, .2);
	border-radius: 1.1rem;
}

.mybtn {
	border-radius: 50px;
}

.login-or {
	position: relative;
	color: #aaa;
	margin-top: 10px;
	margin-bottom: 10px;
	padding-top: 10px;
	padding-bottom: 10px;
}

.span-or {
	display: block;
	position: absolute;
	left: 50%;
	top: -2px;
	margin-left: -25px;
	background-color: #fff;
	width: 50px;
	text-align: center;
}

.hr-or {
	height: 1px;
	margin-top: 0px !important;
	margin-bottom: 0px !important;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-5 mx-auto">
				<div id="first">
					<div class="myform form ">
						<div class="logo mb-3">
							<div class="col-md-12 text-center">
								<h1>Login</h1>
							</div>
						</div>
						<form action="Login" method="post" name="login">
							<div class="form-group">
								<label for="Loginid">Login Id</label> <input type="loginid"
									name="loginid" class="form-control" id="email"
									placeholder="Enter loginid" autofocus required="Please fill out this" >
							</div>
							<div class="form-group">
								<label for="Password">Password</label> <input type="password"
									name="password" id="password" class="form-control"
									placeholder="Enter Password">
							</div>
							<div class="col-md-12 text-center ">
								<button type="submit"
									class=" btn btn-block mybtn btn-primary tx-tfm">Login</button>
							</div>
							<div class="col-md-12 ">
								<div class="login-or">
									<hr class="hr-or">
									<span class="span-or">or</span>
								</div>
							</div>
							<div class="form-group">
								<p class="text-center">
									Don't you remember your password? <a href="forgotpassword.html"
										id="forgotpassword">Click here</a>
								</p>
							</div>
							<div class="form-group">
								<p class="text-center">
									Don't have account? <a href="kycForm.jsp" id="signup">Sign
										up here</a>
								</p>
							</div>
							<div class="errormessage">${MESSAGE}</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>