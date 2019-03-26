<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style/style.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Payee</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
<script src="js/app-ajax.js" type="text/javascript"></script>
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

input[type=text], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}
</style>
</head>
<body>
	<div class="w3-display-bottommiddle"
		style="color: black; font-family: Georgia; font-style: italic; font-size: 14px;"
		align="center">
		<h3 class="heading">Add Payee</h3>
	</div>
	<br />
	<br />
	<form action="PayeeServlet" method="post">
		<div class="w3-display-bottommiddle" style="color: black"
			align="center">

			<div class="w3-display-bottommiddle" style="color: black">
				<p class="p">
					<input type="text" id="holdername" class="form-control"
						style="width: 30%" required name="holdername"
						placeholder="Account Holder Name">
				</p>
			</div>
			<div class="w3-display-bottommiddle" style="color: black">
				<p class="p">
					<input type="text" id="accountno" class="form-control"
						style="width: 30%" required name="accountno"
						placeholder="Account No">
				</p>
			</div>
			<div class="w3-display-bottommiddle" style="color: black">
				<p class="p">
					<select name="bankname" id="bankName" style="width: 30%" required>
						<option value="">Select bank</option>
						<c:forEach var="bankl" items="${BANKS}">
							<option value="${bankl.bankName}">${bankl.bankName}</option>
						</c:forEach>
					</select>
				</p>
			</div>
			<div class="w3-display-bottommiddle" style="color: black">
				<p class="p">
					<select name="branchname" id="branchname" style="width: 30%">
					</select>
				</p>
			</div>
			<div>${MESSAGE}</div>
			<div>
				<button type="submit" class="btn btn-primary btn-danger">Add</button>

			</div>
		</div>
	</form>
	<br />
</body>
</html>