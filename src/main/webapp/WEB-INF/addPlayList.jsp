<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="/css/addSong.css">

</head>
<body>

	<div class="AllContainer">

		<%@ include file="/WEB-INF/navbar.jsp"%>


		<center>
			<div class="formContainer">
				<form:form action="/playlists/new" method="post"
					modelAttribute="playlist">
					<legend>Add a playlist:</legend>
					<p>
						<form:errors path="name"></form:errors>
						<form:label path="name">Playlist Name: </form:label>
						<form:input type="text" path="name" />
					</p>

					<input class="input" class="button" type="submit" value="Add" />
				</form:form>
			</div>
		</center>

	</div>
</body>
</html>