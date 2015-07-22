<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" media="screen" type="text/css" href="css/moviestyle.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Movie'S'tuff</title>
</head>
<body id="bod">
<img id="anim" src="pictures/title2.JPG" alt="website name" height="70" width="300" style="float:right;"/>
<div id='menu'>
<br /><nav>
<ul>
   <li class='active'><a href='index.html'><span>Home</span></a></li>
   <li><a href='#'><span>News</span></a></li>
<li><a href='#'><span>Release Dates</span></a></li>
   <li><a href='#'><span>Top Trending Movies</span></a></li>
   <c:if test="${user == null}">
   <li class='last'><a href='signin.html'><span>SignUp / SignIn</span></a></li>
   </c:if>
   <c:if test="${user != null }">
   <li class='last'><a href='profile.html'><span>Profile</span></a></li>
   </c:if>
</ul>
</nav>
</div>
<form class="movi act">
        <input type="text" placeholder="Actors,Directors,Movies...." required>
        <button type="submit">Search</button>
    </form> 
<br /><br /><br /><br /><br /><br /><br />
<br />
</body>
</html>  