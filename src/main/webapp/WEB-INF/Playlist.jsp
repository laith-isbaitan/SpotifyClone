<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<title>Playlist</title>
</head>
<link rel="stylesheet" type="text/css" href="/css/playlist.css">

<body>

	<%@ include file="/WEB-INF/navbar.jsp"%>

	<center>
		<div class="AddPlaylist">

			<h2 class="title1">Playlists</h2>
			<p>
				<a href="/playlists/new">Add a new playlist</a>
		</div>
	</center>

	<div class="d-grid gap-3">

		<p class="tabb">Playlists</p>
		<c:forEach var="playlist" items="${playlists}">

			<div class="p-2 bg-light border">
				<a href="/playlist/${playlist.id}"><c:out
						value="${playlist.name}"></c:out></a>
						
			</div>

		</c:forEach>

	</div>
</body>
</html>