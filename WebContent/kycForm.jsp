<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Bootstrap core CSS -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Material Design Bootstrap -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.5.8/css/mdb.min.css"
	rel="stylesheet">
<meta charset="ISO-8859-1">


<title>kycform</title>
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

#fontstyle {
	font-family: arial;
	font-size: 18px;
}

@media ( min-width :1000px) {
	main {
		padding-left: 150px
	}
}

.myform {
	padding: 4rem;
	width: 100%;
	background-color: #fff;
	background-clip: padding-box;
	border: 1px solid rgba(0, 0, 0, .2);
	border-radius: 1.1rem;
}

.mybtn {
	border-radius: 50px;
}

#durationDiv {
	width: 200px;
}

#durationSpan {
	background-color: darkslategrey;
	height: 30px;
	font-size: 15px
}
</style>
</head>

<body>
	<!--Main layout-->
	<main class="pt-7 mx-lg-5"> <!--Grid row-->
	<div class="fixed-top">
		<div id="buttonDiv" class="md-form">

			<a href="login.html" class="btn btn-primary btn-danger"><span
				class="glyphicon glyphicon-chevron-left"></span> Back</a>

		</div>
	</div>
	<div class="row wow fadeIn">
		<div class="col-md-9 mb-4">
			<!--Card-->
			<div class="card">
				<!--Card content-->
				<div class="card-body">
					<div class="logo mb-5">
						<div class="col-md-12 text-center">
							<h1>Know Your Customer(KYC) Form</h1>
						</div>
					</div>
					<form name="myform" id="formBtn" action="ServletProfile"
						method="post">
						<!-- Grid row -->
						<div class="form-row">
							<!-- Default input -->
							<div class="md-form">
								<i class="fa fa-user fa-2x prefix"></i> <input type="text"
									id="FirstName" class="form-control" required name="firstName"
									placeholder="First Name">
							</div>
							<!-- Default input -->
							<div class="md-form">
								<i class="fa fa-flighter-jet prefix" aria-hidden="true"></i> <input
									type="text" id="LastName" class="form-control" name="lastName"
									placeholder="Last Name">
							</div>
						</div>
						<!-- Grid row -->
						<div class="form-row">
							<!-- Default input -->
							<div class="md-form">
								<i class="fa fa-user fa-2x prefix"></i> <input type="text"
									id="SurName" class="form-control" required name="surName"
									placeholder="Sur Name">
							</div>
							<div class="form-check form-check-inline">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<i class="fa fa-male fa-2x prefix" aria-hidden="true"></i>&nbsp;&nbsp;&nbsp;<input
									type="radio" class="form-check-input" id="gender" name="gender"
									value="F"> <label class="form-check-label"
									for="materialInline1"></label>
							</div>
							<div class="form-check form-check-inline">
								<i class="fa fa-female fa-2x prefix" aria-hidden="true"></i>&nbsp;&nbsp;&nbsp;<input
									type="radio" class="form-check-input" id="gender" name="gender"
									value="M"> <label class="form-check-label" for="gender"></label>
							</div>
						</div>
						<!-- Grid row -->
						<div class="form-row">
							<div id="emailDiv" class="md-form">
								<i class="fa fa-envelope prefix"></i> <input type="email"
									id="Email" name="email" class="form-control validate"
									placeholder="Email" title="abc12@gmail.com"
									pattern="[a-z0-9]+@[a-z]+.[a-z]{2,}" required>
							</div>

							<!-- Default input -->
							<div id="phoneDiv" class="md-form">
								<i class="fa fa-phone prefix" aria-hidden="true"></i> <input
									type="tel" id="Phoneno" name="Phoneno" class="form-control"
									title="only digits allowed" pattern="[6-9]{1}[0-9]{9}"
									maxlength="10" placeholder="Phonenumber" required>
							</div>
						</div>
						<!-- Grid row -->
						<div class="form-row">
							<!-- Default input -->
							<div class="md-form">
								<i class="fa fa-calendar prefix" aria-hidden="true"></i> <input
									required type="date" id="LeaveDate" name="DateofBirth"
									class="form-control">
							</div>
						</div>
						<div class="form-row">
							<!-- Default input -->
							<div class="md-form">
								<i class="fa fa-briefcase fa-2x prefix"></i> <input type="text"
									id="Occupation" class="form-control" required name="occupation"
									placeholder="Occupation Name">
							</div>
						</div>
						<div class="form-row">
							<!-- Default input -->
							<div class="md-form">
								<i class="fa fa-vcard fa-2x prefix"></i> <input type="text"
									id="AadharNumber" class="form-control" required
									name="aadharNumber" placeholder="Aadhar Number">
							</div>
							<div class="md-form">
								<i class="fa fa-flighter-jet prefix" aria-hidden="true"></i> <input
									type="text" id="PanNumber" class="form-control" required
									name="panNumber" placeholder="Pancard Number">
							</div>
						</div>
						<!-- Material inline 1 -->
						<div class="form-check form-check-inline">
							<i class="fa fa-book fa-2x prefix" aria-hidden="true"></i>&nbsp;&nbsp;Account
							type&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio"
								class="form-check-input" id="savings" name="accounttype"
								value="Savings"> <label class="form-check-label"
								for="savings">Savings</label>
						</div>
						<!-- Material inline 2 -->
						<div class="form-check form-check-inline">
							<input type="radio" class="form-check-input" id="current"
								name="accounttype" value="Current"> <label
								class="form-check-label" for="current">Current</label>
						</div>
						<br></br>
						<div id="durationDiv" class="card mb-4 wow fadeIn">
							<span id="durationSpan" class="badge darkgreen">Permanent
								Address</span>
						</div>
						<div class="form-row">
							<!-- Default input -->
							<div class="md-form">
								<i class='fa fa-home fa-2x prefix'></i>
								<textarea id="form10" class="md-textarea form-control" rows="3"
									required placeholder="Address1" name="permenantAddress1"></textarea>

							</div>
							<!-- Default input -->
							<div class="md-form">
								<i class="fa fa-flighter-jet prefix" aria-hidden="true"></i>
								<textarea id="form10" class="md-textarea form-control" rows="3"
									required placeholder="Address2" name="permenantAddress2"></textarea>
							</div>
						</div>
						<div class="form-row">
							<!-- Default input -->
							<div class="md-form">
								<i class="fa fa-info fa-2x prefix"></i><input type="text"
									id="City" class="form-control" required placeholder="City"
									name="city">
							</div>
							<!-- Default input -->
							<div id="pincodeDiv" class="md-form">
								<i class="fa fa-flighter-jet prefix" aria-hidden="true"></i> <input
									type="tel" id="Pincode" name="Pincode" class="form-control"
									placeholder="Pincode">
							</div>
						</div>
						<div class="form-row">
							<div class="checkbox">
								<i class="fa-2x prefix" aria-hidden="true"></i> <input
									type="checkbox" name="addresssameas" value="address">
								&nbsp;&nbsp;&nbsp;&nbsp;Same as
							</div>
						</div>
						<br></br>
						<div id="durationDiv" class="card mb-4 wow fadeIn">
							<span id="durationSpan" class="badge darkgreen">Communication
								Address</span>
						</div>
						<div class="form-row">
							<!-- Default input -->
							<div class="md-form">
								<i class="fa fa-home fa-2x prefix"></i>
								<textarea id="form10" class="md-textarea form-control" rows="3"
									placeholder="Address1" name="currentAddress1"></textarea>
							</div>
							<!-- Default input -->
							<div class="md-form">
								<i class="fa fa-flighter-jet prefix" aria-hidden="true"></i>
								<textarea id="form10" class="md-textarea form-control" rows="3"
									placeholder="Address2" name="currentAddress2"></textarea>
							</div>
						</div>
						<div class="form-row">
							<!-- Default input -->
							<div class="md-form">
								<i class="fa fa-info fa-2x prefix"></i> <input type="text"
									id="City" class="form-control" placeholder="City"
									name="currentCity">
							</div>
							<!-- Default input -->
							<div id="pincodeDiv" class="md-form">
								<i class="fa fa-flighter-jet prefix" aria-hidden="true"> </i><input
									type="tel" id="Pincode" name="currentPincode"
									class="form-control" placeholder="Pincode">
							</div>
						</div>
						<!-- Grid row -->
						<div class="form-row">
							<div id="buttonDiv" class="md-form">
								<button id="Submit" type="submit" name="Add"
									class="btn btn-success btn-rounded">
									<i class="fa fa-user-plus" aria-hidden="true"></i>&nbsp;&nbsp;Submit
								</button>
							</div>
							<div>
							${MESSAGE}</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</main>
</body>
</html>