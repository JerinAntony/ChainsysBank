<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style/style.css" type="text/css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<title>Fund Transfer</title>
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

#customers {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#customers td, #customers th {
	border: 1px solid #ddd;
	padding: 8px;
}

#customers tr:nth-child(even) {
	background-color: #f2f2f2;
}

#customers tr:hover {
	background-color: #ddd;
}

#customers th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #4CAF50;
	color: white;
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
	<div align="center">

		<div align="center" class="divsummary">
			<p class="p">Available Balance</p>
			<p class="p">9400</p>
		</div>
	</div>
	<br />
	<form action="AccountSummary" method="post">
		<div align="center" style="font-family: Times New Roman">Mini
			Statement</div>
		<div align="center">
			<table id=table>
				<tr>
					<td>
						<div class="md-form">
							<i class="fa fa-calendar prefix" aria-hidden="true"></i> <input
								required type="date" id="fromdate" name="fromdate"
								class="form-control">
						</div>
					</td>
					<td>
						<div class="md-form">
							<i class="fa fa-calendar prefix" aria-hidden="true"></i> <input
								required type="date" id="todate" name="todate"
								class="form-control">
						</div>
					</td>
					<td>
						<div>
							<button target="_blank" type="submit"
								class="btn btn-danger waves-effect btn-sm" id="Logout">
								&nbsp;&nbsp;&nbsp;&nbsp;Search</button>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</form>
	<div>

		<table border="2px" id="customers">
			<tr>
				<th>To Account</th>
				<th>Amount</th>
				<th>Mode</th>
				<th>Status</th>
				<th>Remark</th>
			</tr>
			<c:forEach items="${SUMMARY}" var="summary">
				<tr>
					<td><c:out value="${summary.toAccount.accountNo}" /></td>
					<td><c:out value="${summary.amount}" /></td>
					<td><c:out value="${summary.tranasctionMode}" /></td>
					<td><c:out value="${summary.tranasctionStatus}" /></td>
					<td><c:out value="${summary.remarks}" /></td>
				</tr>

			</c:forEach>
		</table>


	</div>



</body>
</html>