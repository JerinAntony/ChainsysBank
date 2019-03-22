<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style/style.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>footer</title>
<style>
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
	<div class="w3-display-bottommiddle"
		style="color: black; font-family: Georgia; font-style: italic; font-size: 14px;"
		align="center">
		<h3 class="heading">Profile Information</h3>
	</div>
	<div class="w3-display-bottommiddle" style="color: black">
		<p class="p">Name : ${PROFILE.userId.firstName}
			${PROFILE.userId.middleName} ${PROFILE.userId.surName}</p>
	</div>
	<div class="w3-display-bottommiddle" style="color: black">
		<p class="p">Phone no : ${PROFILE.userId.phoneNumber}</p>
	</div>
	<div class="w3-display-bottommiddle" style="color: black">
		<p class="p">Email : ${PROFILE.userId.email}</p>
	</div>
	<div class="w3-display-bottommiddle" style="color: black">
		<p class="p">Gender : ${PROFILE.gender}</p>
	</div>
	<div class="w3-display-bottommiddle" style="color: black">
		<p class="p">Date of Birth : ${PROFILE.dateOfBirth}</p>
	</div>
	<div class="w3-display-bottommiddle" style="color: black">
		<p class="p">Aadhaar No : ${PROFILE.aadharNo}</p>
	</div>
	<div class="w3-display-bottommiddle" style="color: black">
		<p class="p">Pan No : ${PROFILE.pancard}</p>
	</div>
	<div class="w3-display-bottommiddle" style="color: black">
		<p class="p">
			Communication Address : <br/>${CURRENTADDRESS.addressLineone}
			${CURRENTADDRESS.addressLinetwo}</br>${CURRENTADDRESS.cityId.location}</br>${CURRENTADDRESS.cityId.pincode}</p>
	</div>
</body>
</html>