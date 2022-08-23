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
<body>
	<div class="AllContainer">
		<div class="navBar">
			<%@ include file="/WEB-INF/navbar.jsp"%>
		</div>


		<h1>Others who added ...... - ........</h1>
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