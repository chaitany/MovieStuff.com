<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" media="screen" type="text/css" href="css/ourstyle.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>About Us</title>
</head>
<body id="bo">
<img src="pictures/About and release title.JPG" alt="website name" height="70" width="220" style="float:right;"/>
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
<li><form>
<div id="mainContent">
<input placeholder="Search Actors,Directors..." type="text" style="position:absolute;top:25px;"><input type="image" src="pictures/search.png" alt="search" width="30" height="30" style="position:absolute;right:321px;"> 
</div>
</form>
</li>
</ul>
</nav>
</div>
<h2> About US</h2>
<div class="container">
	<div id="content-slider">
    	<div id="slider">
        	<div id="mask">
            <ul>
           	<li id="first" class="firstanimation">
            <a href="pictures/ce_2014.JPG">
            <img src="pictures/ce_2014.jpg" alt="christie"/>
            </a>
            <div class="tooltip">
            <h1>Christian Erickson - Server Side Developer</h1>
            </div>
            </li>

            <li id="second" class="secondanimation">
            <a href="#">
            <img src="lakshmi.jpg" alt="narayan"/>
            </a>
            <div class="tooltip">
            <h1>Narayan M P L- Server Side Developer</h1>
            </div>
            </li>
            
            <li id="third" class="thirdanimation">
            <a href="#">
            <img src="denis.jpg" alt="deni"/>
            </a>
            <div class="tooltip">
            <h1>Denis Alekseev - Front End Developer</h1>
            </div>
            </li>
                        
            <li id="fourth" class="fourthanimation">
            <a href="#">
            <img src="torna.jpg" alt="Soro"/>
            </a>
            <div class="tooltip">
            <h1>Torna Soro - Server Side helper</h1>
            </div>
            </li>
                        
            <li id="fifth" class="fifthanimation">
            <a href="#">
            <img src="chaitu.jpg" alt="chai"/>
            </a>
            <div class="tooltip">
            <h1>Chaitanya - Front End Developer</h1>
            </div>
            </li>
            </ul>
            </div>
            <div class="progress-bar"></div>
        </div>
    </div>  
</div>
<div class="transbox">
<p>Hi all,</p>
<p>We are Computer Science Graduate students of UMass Boston, Massachusetts. We developed this website basing on the craze the people have towards movies. Here we are providing all the movie news, top trending movies, release dates, blah,blah,blah.... but wait here is the interesting part, we are letting the viewers to sign up to create their own accounts.</p>
<p>So what, what's new about this?. Now here, in your account, you can enter your favorite actor, favorite director, favorite screen writer, favorite studio... whatever your favorites. And every time when you log in you can see the updates of your favorites'.</p>
</div>
<p style="position:absolute;bottom:10px;font-size:23px;color:#a62f03;"><a href="about.html">About Us</a>|<a href="Advertise.html">Advertising</a>
</p> 
</body>
</html>