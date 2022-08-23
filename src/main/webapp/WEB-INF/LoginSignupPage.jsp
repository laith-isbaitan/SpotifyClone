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
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<link rel="stylesheet" type="text/css" href="/css/login.css">

<body>
	<center>
		<div class="AllContainer">
			<center>
				<img src="images\spotifylogo3.png" alt="spotify Logo" width="100"
					height="100">
			</center>
		    
			<div class="LoginDiv">
				<form action="/login" method="post" >
				    <c:if test="${logoutMessage != null}">
        				<c:out value="${logoutMessage}"></c:out>
		    		</c:if>	
		    		    
				    <c:if test="${errorMessage != null}">
				        <c:out value="${errorMessage}"></c:out>
				    </c:if>
				    
					<h1>To continue, log in to spotify</h1>
					<div>
						<label class="text"> Email address: </label><br> 
						<input	type="text" name="username" class="form-control"/>
	
					</div>
	
					<div>
						<label class="text"> password: </label><br>	
						<input	type="password" name="password" class="form-control"/>
	
					</div>
	
					<div>
				        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

						<input class="login" type="submit" value="LOG IN" />
					</div>
				</form>
			</div>
			
			<!-- btn btn-primary -->


			<div class="SignupDiv">
				<form:form action="/registration" method="post" modelAttribute="user">
				
					<h1>Sign up for free to start listening.</h1>
	
					<div>
						<form:errors path="email"></form:errors>
						<label class="text"> What's your email? </label><br> 
						<form:input type="text" path="email" class="form-control"/>
	
					</div>
	
					<div>
						<form:errors path="firstName"></form:errors>
						<label class="text"> First Name </label><br> 
						<form:input	type="text" path="firstName" class="form-control"/>
	
					</div>
	
					<div>
						<form:errors path="lastName"></form:errors>
						<label class="text"> Last Name </label><br> 
						<form:input type="text"	path="lastName" class="form-control"/>
	
					</div>
	
					<div>
						<form:errors path="password"></form:errors>
						<label class="text">create password:</label><br> 
						<form:input	type="password" path="password" class="form-control"/>
	
					</div>
	
					<div>
						<form:errors path="confirm"></form:errors>
						<label class="text">Confirm password:</label><br> 
						<form:input	type="password" path="confirm" class="form-control"/>
	
					</div>
					
					<div>				        
						<input type="submit" value="Sign Up" class="signUp"/>
					</div>
				</div>
			</form:form>
		</div>
	</center>


</body>
</html>