<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" media="screen" type="text/css" href="css/home.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Movie'S'tuff</title>
</head>
<body id="bod">
	<div id="wrapper">
	<span id="headline"> News with your favorites? <br />
	It's easy with Movie'S'tuff! </span>
	<img id="anim" src="pictures/title2.JPG" alt="website name" height="70" width="220" style="float:left;"/>
	<div id='menu'>
<br /><nav>
<ul>
   <li class='active'><a href="movie'S'tuff.html"><span>Home</span></a></li>
   <li><a href="movieNews.html"><span>News</span></a></li>
<li><a href="release.html"><span>Release Dates</span></a></li>
   <li><a href="top.html"><span>Top Trending Movies</span></a></li>
   <c:if test="${user == null}">
   <li class='last'><a href='signin.html'><span>SignUp / SignIn</span></a></li>
   </c:if>
   <c:if test="${user != null }">
   <li class='last'><a href='profile.html'><span>Profile</span></a></li>
   </c:if>
</ul>
</nav>
</div>

<div id="container">
	
	
	
<!--sign in form-->
<div id="logFormHome">
	<form id="logForm" action="signin.html">
			
			<input name="userNameHome" id="userNameHome" class="field" type="text" placeholder="User Name" size="15" maxlenght="30" /> 			
			<input name="passwordHome" id="passwordHome" class="field" type="password" placeholder="Password" size="15" maxlength="20"  /> 			
			<input id="loginButtonHome" type="submit" value="Login" />

			<nav>
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
<!--             -->



<!--
<form class="movi act">
        <input type="text" placeholder="Actors,Directors,Movies...." required>
        <button type="submit">Search</button>
</form>
-->


<div id="box">


<!--//////////////////search boxes/////////////////--> 

<div id="searchFormHome">
	<form id="searchForm" action="movieNews.html" method="post">

			
			<!--
			Start to search for <span> news </span> and <span> release dates of movies </span> with your <span> favorite </span> actors, directors, producers, scenario writers,  writers, film studios and movie genres right now! <br/> <br/>
			-->
			<div>
			Enter your <span> favorite </span> actor, director, producer, scenario writer, film studio or movie genre <br/> <br/>
			</div>

			<span id="big"> News Search </span> <br/> <br />
			
			<input name="searchTerm" id="newsSearch" class="field" type="text" 
			placeholder="Actors, Directors, ..." size="30" maxlenght="30" /> 
			

			<input id="newsSearchButtonHome" type="image" src="./pictures/search.png" alt="search" onclick="newsSearch();"/> <br /> <br /> <br/>

			<span id="big"> Release Dates Search </span> <br/> <br />

			<input name="releaseDates" id="releaseDates" class="field" type="text" 
			placeholder="Actors, Directors, ..." size="30" maxlength="20"  />

			<input id="relDatesSearchButtonHome" type="image" src="./pictures/search.png" alt="search" onclick="datesSearch();"/> <br />


			
	</form>
</div>


<!--//////////////////Welcoming/////////////////--> 

<div id="welcomeFormHome">
	<form id="welcomeForm" action="">

			<div>
			<span id="welc"> Welcome to Movie'S'tuff! </span> <br /> <br />
			Movie'S'tuff is the premiere online destination for movie enthusiasts, providing the latest news in movie world. 
			<br /><br />
			You can search for <span> news </span> and <span> release dates of movies </span> with your <span> favorite </span> actors, directors, producers, scenario writers,  writers, film studios and movie genres without any registration.
			<br /><br />
			<a href="signin.html"> Register </a> 
			your account and get many additional features like personalized news, release dates and many more.
			</div>
	</form>

			
		</div>
			
	</div>


</div>


</div>

<div id="trailers">
<span class="asideTitle"> Top New Trailers </span> <br /> <br />
<span id="trailerTitle"> Interstellar </span> <br />
<video width="300" controls>
  <source id="ss" src="video/trailer1.mp4" type="video/mp4">
Your browser does not support the video tag.
</video>
<br /> <br />

<span id="trailerTitle"> Transformers </span> <br />
<video width="300" controls>
  <source id="ss" src="video/trailer2.mp4" type="video/mp4">
Your browser does not support the video tag.
</video>
</div>

<div id="trendMovies">
<span class="asideTitle"> Top Trending Movies </span> <br /> <br />
1. <a href="http://www.fandango.com/boxoffice" style="text-decoration:none;">Neighbors</a> <br />
2. <a href="http://www.fandango.com/boxoffice" style="text-decoration:none;">The Amazing Spider Man 2</a> <br />
3. <a href="http://www.fandango.com/boxoffice" style="text-decoration:none;">The Other Woman</a> <br />
4. <a href="http://www.fandango.com/boxoffice" style="text-decoration:none;">Heaven is for Real</a> <br />
5. <a href="http://www.fandango.com/boxoffice" style="text-decoration:none;">Captain America: The Winter Soldier</a> <br />
6. <a href="http://www.fandango.com/boxoffice" style="text-decoration:none;">Captain America: The Winter Soldier</a> <br />
7. <a href="http://www.fandango.com/boxoffice" style="text-decoration:none;">Rio2</a> <br />
8. <a href="http://www.fandango.com/boxoffice" style="text-decoration:none;">Mom's Night Out</a> <br />
9. <a href="http://www.fandango.com/boxoffice" style="text-decoration:none;">Legends Of OZ: Dorothy's Return</a> <br />
10. <a href="http://www.fandango.com/boxoffice" style="text-decoration:none;">Divergent</a> <br />
</div>


</body>
</html>  