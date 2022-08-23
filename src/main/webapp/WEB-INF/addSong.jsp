	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
     <%@ include file="./css/addSong.css"%>
</style>
</head>
<body>
	<div class="formContainer">
		<form:form name="addSongForm" method="post" modelAttribute="addSongForm">
			<legend>Add a song:</legend>
			<p>
				<form:errors path="title"></form:errors>
				<form:label path="title">Song Title: </form:label>
				<form:input type="text" path="title"/>
			</p>
			<p>
				<form:errors path="artist"></form:errors>
				<form:label path="artist">Artist Name: </form:label>
				<form:input type="text" path="artist"/>
			</p>
			<input type="submit" value="Add Song"/>
		</form:form>
	</div>
</body>
</html>