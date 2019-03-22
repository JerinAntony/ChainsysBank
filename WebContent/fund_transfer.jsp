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
		<h3 class="heading">Fund Transfer</h3>
	</div>
	<br />
	<br />
	<div class="w3-display-bottommiddle" style="color: black">
		<p class="p"></p>
	</div>

	<div class="row">
		<div class="col-sm-4" style="color: black">
			<p class="p">
				<span style="font-weight: bold">Payee : </span><select style="width: 30%"></select>
			</p>
		</div>
		<div class="col-sm-4"></div>
		<div class="col-sm-4">
			<a href="PayeeServlet" class="btn btn-primary btn-danger"><span
				class="glyphicon glyphicon-chevron-left"></span> Add Payee</a>
		</div>
	</div>
	<div class="w3-display-bottommiddle" style="color: black">
		<p class="p">
			<span style="font-weight: bold">Amount : <input type="text"
				id="amount" class="form-control" style="width: 30%" required
				name="amount" placeholder="Amount"></span>
		</p>
	</div>
	<div class="w3-display-bottommiddle" style="color: black">
		<p class="p">
			<span style="font-weight: bold">Remarks : <input type="text"
				id="remark" class="form-control" style="width: 30%" required
				name="remark" placeholder="Enter Remarks"></span>
		</p>
	</div>
	<div >
		<a href="login.jsp" class="btn btn-primary btn-danger" style="width: 20%"><span
			class="glyphicon glyphicon-chevron-left"></span> Proceed</a>
	</div>
	<br />
	<br />
	<div class="row">
		<div class="col-sm-4" style="color: black">
			<p class="p">From</p>
			<p class="p">Savings Account</p>
			<p class="p">123455</p>
		</div>
		<div class="col-sm-4" style="color: black">
			<p class="p">Available Balance</p>
			<p class="p">123455</p>
		</div>
		
	</div>

</body>
</html>