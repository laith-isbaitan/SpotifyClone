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

<link rel="stylesheet" type="text/css" href="/css/user.css">


<title>User's Playlist</title>
</head>
<body>
	<div class="AllContainer">
		<div class="navBar">
			<%@ include file="/WEB-INF/navbar.jsp"%>

		</div>

		<div class="body">
			<h1>
				<c:out value="${currUser.getFirstName()}"></c:out>
				<c:out value="${currPlaylist.getName()}"></c:out>
			</h1>
			<br>


			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">Title</th>
						<th scope="col">Artist</th>
						<th scope="col">Times Added</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="song" items="${currPlaylist.getSongs()}" varStatus="index">
						<tr>
							<td>${song.getTitle() }</td>
							<td>${song.getArtist() }</td>
							<td>${play_song}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>