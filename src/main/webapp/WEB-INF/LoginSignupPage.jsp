<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<link rel="stylesheet" type="text/css" href="/css/login.css">

<body>
	<center>
		<div class="AllContainer">
			<center>
				<img src="images\spotifylogo3.png" alt="spotify Logo" width="100"
					height="100">
			</center>


			<div class="LoginDiv">
				<h1>To continue, log in to spotify</h1>
				<div>
					<label class="text"> Email address: </label><br> <input
						type="text" name="Name" class="form-control">

				</div>

				<div>
					<label class="text"> password: </label><br> <input
						type="password" name="Password" class="form-control">

				</div>

				<div>
					<button class="login">LOG IN</button>
				</div>
			</div>
			<!-- btn btn-primary -->


			<div class="SignupDiv">
				<h1>Sign up for free to start listening.</h1>

				<div>
					<label class="text"> What's your email? </label><br> <input
						type="text" name="Name" class="form-control">

				</div>

				<div>
					<label class="text"> First Name </label><br> <input
						type="text" name="Name" class="form-control">

				</div>

				<div>
					<label class="text"> Last Name </label><br> <input type="text"
						name="Name" class="form-control">

				</div>

				<div>
					<label class="text">create password:</label><br> <input
						type="password" name="Password" class="form-control">

				</div>

				<div>
					<label class="text">Confirm password:</label><br> <input
						type="password" name="Password" class="form-control">

				</div>

				<div>
					<button class="signUp">sign Up</button>
				</div>
			</div>
		</div>
	</center>


</body>
</html>