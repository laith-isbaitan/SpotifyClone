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
     <%@ include file="./css/dashboard.css"%>
</style>
</head>
<body>

	<h1>Hello, ____user___</h1>
	<p>All the songs in out hub: </p>
	<div class="container">
		<table>
			<tbody>
				<tr>
					<td>
						<div class="card">
							<h2>Better</h2>
							<p>By: DJ Khalid</p>
							<p>Added: 200</p>
							<input class="addBtn" type="submit" value="ADD"/>
						</div>
					</td>
					<td>
						<div class="card">
							<h2>Better</h2>
							<p>By: DJ Khalid</p>
							<p>Added: 200</p>
							<input class="addBtn" type="submit" value="ADD"/>
						</div>
					</td>
					<td>
						<div class="card">
							<h2>Better</h2>
							<p>By: DJ Khalid</p>
							<p>Added: 200</p>
							<input class="addBtn" type="submit" value="ADD"/>
						</div>
					</td>
					<td>
						<div class="card">
							<h2>Better</h2>
							<p>By: DJ Khalid</p>
							<p>Added: 200</p>
							<input class="addBtn" type="submit" value="ADD"/>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</div>

</body>
</html>