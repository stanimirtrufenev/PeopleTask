<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Sergey Pozhilov (GetTemplate.com)">

<title>My Application</title>
<spring:url value="/resources/assets/images/gt_favicon.png"
	var="crunchifyCSS1" />
<link href="${crunchifyCSS1}" rel="shortcut icon" />

<!-- Bootstrap itself -->
<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">

<!-- Custom styles -->
<spring:url value="/css/magister.css" var="crunchifyCSS" />
<link href="${crunchifyCSS}" rel="stylesheet" />

<!-- Fonts -->
<link
	href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href='http://fonts.googleapis.com/css?family=Wire+One'
	rel='stylesheet' type='text/css'>
</head>

<!-- use "theme-invert" class on bright backgrounds, also try "text-shadows" class -->
<body class="theme-invert">

	<nav class="mainmenu">
		<div class="container">
			<div class="dropdown">
				<button type="button" class="navbar-toggle" data-toggle="dropdown">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<!-- <a data-toggle="dropdown" href="#">Dropdown trigger</a> -->
				<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
					<li><a href="#head" class="active">Hello</a></li>
					<li><a href="#themes">Search</a></li>
					<li><a href="#about">Create</a></li>
				</ul>
			</div>
		</div>
	</nav>


	<!-- Main (Home) section -->
	<section class="section" id="head">
		<div class="container">

			<div class="row">
				<div
					class="col-md-10 col-lg-10 col-md-offset-1 col-lg-offset-1 text-center">

					<!-- Site Title, your name, HELLO msg, etc. -->
					<h1 class="title">Application for searching people</h1>




					<!-- Nice place to describe your site in a sentence or two -->

				</div>
				<!-- /col -->
			</div>
			<!-- /row -->

		</div>
	</section>

	<!-- Second (About) section -->
	<section class="section" id="about">
		<div class="container">

			<h2 class="text-center title">Create</h2>
			<p class="text-center mine" id="test_me">No empty fields ! !</p>
			<p class="text-center mine" id="names">Name must contain only letters!</p>
			<p class="text-center mine" id="names3">This field must not be empty!</p>
			<p class="text-center mine" id="names2">Pin must contain only 10 numbers!</p>
			<p class="text-center mine" id="names4">The email is not valid(abv@abv.bg)!</p>
			
			<div class="row">
				<div class="col-sm-3 col-sm-offset-1">
					<h5>
						<strong>Full Name<br></strong>
						</h2>
						<input class="btn btn-default btn-lg" id="fullName" type="text"
							placeholder="Full Name"> <br>
						<h5>
							<strong>PIN<br></strong>
						</h5>
						<input class="btn btn-default btn-lg" id="pin" type="text"
							placeholder="PIN"> <br>
				</div>
				<div class="col-sm-3">
					<h5>
						<strong>Address Type<br></strong>
					</h5>
					<select  class="btn btn-default btn-lg" id="addressType">
						<option value="home">Home</option>
						<option value="temporary">Temporary</option>
					</select>

					<br>
					<h5>
						<strong>Address Info<br></strong>
					</h5>
					<input class="btn btn-default btn-lg" id="addressInfo" type="text"
						placeholder="Address Info"> <br>
				</div>

				<div class="col-sm-3">
					<h5>
						<strong>Email Type<br></strong>
					</h5>
			
					<select class="btn btn-default btn-lg" id="emailType">
						<option value="abv">abv</option>
						<option value="gmail">gmail</option>
						<option value="yahoo">yahoo</option>
					</select> <br>
					<h5>
						<strong>Email<br></strong>
					</h5>
					<input class="btn btn-default btn-lg" id="email" type="text"
						placeholder="Email"> <br>
				</div>

				<div class="col-sm-3">
					<br>
					<h5>
						<strong>Create<br></strong>
					</h5>
					<p>
						<button class="btn btn-default btn-lg" onclick="submitCreate()">Create</button>
					</p>
					<br>
				</div>
				<br>

			</div>
		</div>
	</section>

	<!-- Third (Works) section -->
	<section class="section" id="themes">
		<div class="container">

			<h2 class="text-center title">Search</h2>
			<p class="lead text-center">
				Enter name<a href="http://unsplash.com"></a>
			</p>
			
				<p class="text-center mine" id="names15">Please enter name</p>
			<div class="row">
				<div class="col-sm-4 col-sm-offset-2">
					<h5>
						<strong>Name:<br></strong>
					</h5>
					<input class="btn btn-default btn-lg" id="searchName" type="text"
						placeholder="Name">
				</div>
				<div class="col-sm-8 col-sm-offset-2">
					<h5>
						<strong>Search:<br></strong>
					</h5>
					<p>
						<button class="btn btn-default btn-lg" onclick="submitSearch()">Search</button>
					</p>
				</div>

			</div>

		</div>
	</section>

	<!-- Fourth (Contact) section -->
	<section class="section" id="contact">
		<div class="container">

			<h2 class="text-center title">Get in touch</h2>

			<div class="row">
				<div class="col-sm-8 col-sm-offset-2 text-center">
					<p class="lead">Have a question about this template, or want to
						suggest a new feature?</p>
					<p>Feel free to email me, or drop me a line in Twitter!</p>
					<p>
						<b>gt@gettemplate.com</b><br>
						<br>
					</p>
					<ul class="list-inline list-social">
						<li><a href="https://twitter.com/serggg" class="btn btn-link"><i
								class="fa fa-twitter fa-fw"></i> Twitter</a></li>
						<li><a href="https://github.com/pozhilov"
							class="btn btn-link"><i class="fa fa-github fa-fw"></i>
								Github</a></li>
						<li><a href="http://linkedin/in/pozhilov"
							class="btn btn-link"><i class="fa fa-linkedin fa-fw"></i>
								LinkedIn</a></li>
					</ul>
				</div>
			</div>

		</div>
	</section>


	<!-- Load js libs only when the page is loaded. -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script
		src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
	<spring:url value="/resources/assets/js/modernizr.custom.72241.js"
		var="crunchifyJS" />
	<script src="${crunchifyJS}"></script>
	<!-- Custom template scripts -->
	<spring:url value="/js/magister.js" var="crunchifyJS1" />
	<script src="${crunchifyJS1}"></script>
</body>
</html>