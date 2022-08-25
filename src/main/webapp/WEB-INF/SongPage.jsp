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
<title>Insert title here</title>
</head>
<body>
	<div class="AllContainer">
		<div class="navBar">
			<%@ include file="/WEB-INF/navbar.jsp"%>
		</div>


		<h1>
			Others who added
			<c:out value="${currSong.getTitle()}"></c:out>
			- <c:out value="${currSong.getArtist()}"></c:out>
		</h1>
		<br>

		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Times Added</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<!-- for each -->
				</tr>

			</tbody>
		</table>

	</div>
</body>
</html>