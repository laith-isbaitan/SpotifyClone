<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<title>Dashboard</title>


<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/dashboard.css">
</head>
<link rel="stylesheet" type="text/css" href="/css/dashboard.css">

<body>

	<div class="navBar">

		<nav class="navbar navbar-expand-xl navbar-light bg-light">
			<div class="container-fluid">
				<img src="/images/spotifylogo3.png" alt="spotify Logo" width="50"
					height="50">
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarText"
					aria-controls="navbarText" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<span class="navbar-text"> <a class="nav-link active"
					aria-current="page" href="/users">Playlist</a>
				</span> <span class="navbar-text"> <a class="nav-link active"
					aria-current="page" href="/dash">Dashboard</a>
				</span>
					<form id="logoutForm" method="POST" action="/logout">
		       			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						<span class="navbar-text"> 
							<input class="nav-link active" aria-current="page" 
							type="submit" value="Logout!" />					
						</span>
	    			</form>
			</div>
		</nav>

	</div>



	<h1>Hello, <c:out value="${currUser.getFirstName()}"></c:out></h1>
	<p>All the songs in our hub:</p>
	
	<p><a href="/songs/new">Insert a new song</a></p>
	
	
	<div class="container">

		<c:forEach var="song" items="${songs}">
			<center>
				<div class="card2">
					<h1>
						<a href="/songs/${song.id}"><c:out value="${song.title}"></c:out></a>
					</h1>
					<h2>
						<c:out value="${song.artist}"></c:out>
					</h2>
					<input class="addBtn" type="submit" value="ADD" />
				</div>
			</center>
		</c:forEach>
	</div>

</body>
</html>