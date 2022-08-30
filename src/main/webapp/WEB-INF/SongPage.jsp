<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" type="text/css" href="/css/SongPage.css">


</head>

<body>
	<div class="navBar">
		<%@ include file="/WEB-INF/navbar.jsp"%>
	</div>


	<div class="background"></div>
	<section>
		<div class="album-info">
			<div class="album-art">
				<img src="https://images.pexels.com/photos/164853/pexels-photo-164853.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" />

			</div>
			<div class="album-details">
				<h1>
					<c:out value="${currSong.getTitle()}"></c:out>
					by
					<c:out value="${currSong.getArtist()}"></c:out>
				</h1>
			</div>
		</div>
		<div class="album-tracks">
			<ol>
				<li><span>Feel Invincible</span><span>3:49</span></li>
				<li><span>Back From The Dead</span><span>3:33</span></li>
				<li><span>Stars</span><span>3:47</span></li>
				<li><span>I Want To Live</span><span>3:28</span></li>
				<li><span>Undefeated</span><span>3:35</span></li>
				<li><span>Famous</span><span>3:18</span></li>
			</ol>
		</div>
	</section>
</body>

</html>