<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Font Awesome -->
<link rel="stylesheet" href="css/font-awesome.min.css">
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Material Design Bootstrap -->
<link href="css/mdb.min.css" rel="stylesheet">

<meta charset="ISO-8859-1">
<title>Home</title>
<style>
.sidebar-fixed {
	height: 100vh;
	width: 270px;
	-webkit-box-shadow: 0 2px 5px 0 rgba(0, 0, 0, .16), 0 2px 10px 0
		rgba(0, 0, 0, .12);
	box-shadow: 0 2px 5px 0 rgba(0, 0, 0, .16), 0 2px 10px 0
		rgba(0, 0, 0, .12);
	z-index: 1050;
	background-color: #fff;
	padding: 0 1.5rem 1.5rem
}

.sidebar-fixed .list-group .active {
	-webkit-box-shadow: 0 2px 5px 0 rgba(0, 0, 0, .16), 0 2px 10px 0
		rgba(0, 0, 0, .12);
	box-shadow: 0 2px 5px 0 rgba(0, 0, 0, .16), 0 2px 10px 0
		rgba(0, 0, 0, .12);
	-webkit-border-radius: 5px;
	border-radius: 5px
}

.sidebar-fixed .logo-wrapper {
	padding: 2.5rem
}

.sidebar-fixed .logo-wrapper img {
	max-height: 50px
}

@media ( min-width :1200px) {
	.navbar, .page-footer, main {
		padding-left: 270px;
		padding-top: 100px;
	}
}

@media ( max-width :1199.98px) {
	.sidebar-fixed {
		display: none
	}
}

#sidebar {
	padding-top: 20px;
}

html, body {
	height: 100%;
}

#wrap {
	min-height: 100%;
}

.footer {
	position: fixed;
	left: 100px;
	margin-top: 500px;
	bottom: 0;
	width: 100%;
	background-color: white;
	color: black;
	text-align: center;
}
</style>
</head>
<body>
	<header> <!-- Navbar --> <nav
		class="navbar fixed-top navbar-expand-lg navbar-light white scrolling-navbar">
	<div class="container-fluid">

		<div class="collapse navbar-collapse" id="navbarSupportedContent">

			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a>Welcome ${NAME}!!!</a></li>
			</ul>
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><img style="width: 100; height: 30"
					src="image/bankimage.png"></li>
			</ul>
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><img src="image/man.jpg"
					class="img-circle" alt="Cinque Terre" width="80" height="50"></li>
			</ul>
			<ul class="navbar-nav nav-flex-icons">
				<li class="nav-item">
					<form action="LogoutServlet" method="post">
						<button onclick="logout()" target="_blank" type="submit"
							class="btn btn-danger waves-effect btn-sm" id="Logout">
							<i class="fa fa-power-off"></i>&nbsp;&nbsp;&nbsp;&nbsp;LogOut
						</button>
					</form>
				</li>
			</ul>
		</div>

	</div>
	</nav> <!-- Navbar --> <!-- Sidebar -->
	<div class="sidebar-fixed position-fixed" id="side">

		<!-- GMX logo -->
		<div class="list-group list-group-flush" id="sidebar">
			<button class="btn btn-primary btn-wd">Dashboard</button>
			<a href="HomeServlet" id="Lnav"
				class="list-group-item list-group-item-action waves-effect"> <i
				class="fa fa-user-o"> </i>&nbsp;&nbsp;Profile
			</a> <a href="AccountSummary" id="Anav"
				class="list-group-item list-group-item-action waves-effect"> <i
				class="fa fa-th-list"></i>&nbsp;&nbsp;Account Summary
			</a> <a href="FundTransfer" id="Snav"
				class="list-group-item list-group-item-action waves-effect"> <i
				class="	fa fa-send"></i>&nbsp;&nbsp; Fund Transfer
			</a>
			<!-- <a href="#" id="Snav"
				class="list-group-item list-group-item-action waves-effect"> <i
				class="fa fa-money"></i>&nbsp;&nbsp; Bill Pay(Features)
			</a> <a href="#" id="Snav"
				class="list-group-item list-group-item-action waves-effect"> <i
				class="	fa fa-asl-interpreting"></i>&nbsp;&nbsp; Loan(Features)
			</a> -->
		</div>
	</div>
	<!-- Sidebar --> </header>
	<main class="pt-5 mx-lg-5">
	<div class="w3-display-middle" style="padding-top: 50px">
		<c:if test="${PROFILE!=null}">
			<%@ include file="profile.jsp"%>
		</c:if>
		<c:if test="${FUNDTRANSFER!=null}">
			<%@ include file="fund_transfer.jsp"%>
		</c:if>
		<c:if test="${PAYEEPAGE!=null}">
			<%@ include file="payee.jsp"%>
		</c:if>

		<c:if test="${SUMMARYPAGE!=null}">
			<%@ include file="accounts_summary.jsp"%>
		</c:if>
	</div>
	<div class="footer">
		<p style="font-family: Times New Roman">© 2019 Copyright:Chainsys
			Bank</p>
	</div>
	</main>

</body>
</html>
