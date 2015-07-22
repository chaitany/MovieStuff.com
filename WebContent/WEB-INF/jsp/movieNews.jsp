<%@page import="com.movie.presentation.web.NewsController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" media="screen" type="text/css" href="css/news.css">
<script src="scripts/jquery-1.10.2.js" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>News</title>

<script>
</script>
</head>
<body id="body">
<img id="anim" src="pictures/News and top title.JPG" alt="website name" height="70" width="220" style="float:right;"/>
<div id='menu'>
<br /><nav>
<ul>
   <li><a href="movie'S'tuff.html"><span>Home</span></a></li>
   <li class='active'><a href="movieNews.html"><span>News</span></a></li>
<li><a href="release.html"><span>Release Dates</span></a></li>
   <li><a href="top.html"><span>Top Trending Movies</span></a></li>
   <c:if test="${user == null}">
   <li class='last'><a href='signin.html'><span>SignUp / SignIn</span></a></li>
   </c:if>
   <c:if test="${user != null }">
   <li class='last'><a href='profile.html'><span>Profile</span></a></li>
   </c:if>
<li><form action="movieNews.html" method="post">
<div id="mainContent">
<input id="searchTerm" placeholder="Search Actors,Directors..." type="text" style="position:absolute;top:118px;" name="searchTerm" />
<input type="image" src="pictures/search.png" alt="search" width="30" height="30" style="position:absolute;right:321px;"> 
</div>
</form>
</li>
</ul>
</nav>


<div id="logFormHome" >
	<form id="logForm" action="signin.html">
			
			<input name="userNameHome" id="userNameHome" class="field" type="text" placeholder="User Name" size="15" maxlength="30" /> 			
			<input name="passwordHome" id="passwordHome" class="field" type="password" placeholder="Password" size="15" maxlength="20"  /> 			
			<input id="loginButtonHome" type="submit" value="Login" />

			<nav >
					<div id="sign-bar-home">
   						<a href="signin.html"><span>Register</span></a> |
   						<a href='#'><span>Forgot password?</span></a> |
						<a href='#'><span>Help</span></a> |
   						<a href='#'><span>Save login</span></a>
   						<input name="checkBox" type="checkbox"/>  

   					</div>
				
			</nav>

	</form>

</div>

</div> <div class="transbox">
      
        <c:forEach items="${feedItems }" var="feedItem">
        	<h2 class="feed_title">${feedItem.title} </h2>
        	<p class="feed_desc">${feedItem.description }</p>>
        	<p class="feed_link"><a href="${feedItem.linkUrl }">More...</a></p>
        </c:forEach>
      
      </div>
<p style="position:fixed;bottom:10px;right:0px;font-size:23px;color:#a62f03;"><a href="about.html">About Us</a>|<a href="Advertise.html">Advertising</a>
</p>


</body>
</html>  