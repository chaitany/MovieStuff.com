<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
		<link rel="stylesheet" media="screen" type="text/css" href="css/denis_css2/moviestyle.css">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Movie'S'tuff - Registration Form</title>
		<script type="text/javascript" src="scripts/signin.js"></script>
	</head>
<body id="bod">
<div id="wrapper">
		<img id="anim" src="pictures/title2.JPG" alt="website name" height="70" width="300" style="float:right;"/>
		<div id='menu'>
			<br />
			<ul>
   <li><a href="movie'S'tuff.html"><span>Home</span></a></li>
   <li><a href="movieNews.html"><span>News</span></a></li>
<li><a href="release.html"><span>Release Dates</span></a></li>
   <li ><a href="top.html"><span>Top Trending Movies</span></a></li>
   <c:if test="${user == null}">
   <li class='active'><a href='signin.html'><span>SignUp / SignIn</span></a></li>
   </c:if>
   <c:if test="${user != null }">
   <li class='active'><a href='profile.html'><span>Profile</span></a></li>
   </c:if>
</ul>
		</div>

		<br /><br /><br /><br /><br /><br />

		
		<form id="regForm" class="center" action="register.html" method="post" >
			
			<h1> Set up your free account </h1>
			<p>
				Register your account and get many additional features like personalized news, release dates and many more.
			</p>
						
			<p> 
				<div id="err">
					<span id="errMsg1"> </span> <br/>
					<span id="errMsg2"> </span> <br/>
					<span id="errMsg3"> </span> <br/>
				</div>
			</p>

			<p> 
				Email <input name="email" id="email" class="field" type="text" size="30" maxlenght="30" /> 
			</p>
			<p> 
				Username 
				<input name="userName" class="field" type="text" size="30" maxlength="20"  /> <span id="restr"> Minimum 5 characters <span>  
			</p>
			<p> 
				Password <input name="password" id="password" class="field" type="password" size="30" maxlength="20" /> <span id="restr"> Minimum 8 characters </span>
			</p>  

			<br/>
			<p> <input id="signinButton" type="submit" value="SignIn" onclick="return signin();" /> </p>
						
		</form>
	</div>
	<body>
</html>