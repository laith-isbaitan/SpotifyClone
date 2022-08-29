
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
				<form:form action="/songs/new" method="post"
					modelAttribute="addSongForm">
					<legend>Add a song:</legend>
					<p>
						<form:errors path="title"></form:errors>
						<form:label path="title">Song Title: </form:label>
						<form:input type="text" path="title" />
					</p>
					<p>
						<form:errors path="artist"></form:errors>
						<form:label path="artist">Artist Name: </form:label>
						<form:input type="text" path="artist" />
					</p>
					
					<!-- taking the path value and putting it in hidden input -->
					<form:input type="file" id="file" path="imageData" accept="image/jpg" />
					
					<input type="submit" value="Add Song"/>
					
				</form:form>
			</div>
		</center>

	</div>
</body>
</html>