<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Dorms</title>
</head>
<body>

	<h2 class="center">Playlists</h2>
	<p>
		<a href="/playlists/new">Add a new playlist</a>
	</p>


	<table>
		<thead>
			<tr>
				<th>playlists</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="playlist" items="${playlists}">
				<tr>

					<td><a href="/playlist/${playlist.id}"><c:out
								value="${playlist.name}"></c:out></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>