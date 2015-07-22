<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" media="screen" type="text/css" href="css/advertstyle.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Advertisement</title>
</head>
<body id='bode'>
<img id="anim" src="pictures/title2.JPG" alt="website name" height="70" width="220" style="float:right;"/>
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
<input placeholder="Search Actors,Directors..." type="text" style="position:absolute;top:25px;"><input type="image" src="pictures/search.png" alt="search" width="30" height="30" style="position:absolute;right:304px;"> 
</div>
</form></li>
</ul>
</nav>
</div>
<div class="transbox">
<h2 style="color:#a62f03;"> Advertise on Movie'S'tuff.com</h2>
<p>Our website is may be new to this field, but the unique functions which we are offering to the subscribers made us popular and authenticative. Currently the count of visitors is 103 million per month.  Our website display advertising program offers a comprehensive suite of solutions to showcase your messaging to our loyal and engaged audience.</p>
<p>We offer a wide variety of advertising placements and technologies designed to highlight your messaging to the right audience at the right time.</p> 
<h2 style="color:#a62f03;">Contact Information</h4>
<p >please provide us your information</p>
<form action="MAILTO:chaitanya.vaddula001@umb.edu.com" method="post" enctype="text/plain">
First Name    <input type="text" name="first">
Last Name     <input type="text" name="last">
Email         <input type="text" name="mail"><br />
Company       <input type="text" name="company">
City          <input type="text" name="city"><br />
State/Province  <select style="border-radius:5px;border: 2px solid #a62f03;">
	<option value="AL">Alabama</option>
	<option value="AK">Alaska</option>
	<option value="AZ">Arizona</option>
	<option value="AR">Arkansas</option>
	<option value="CA">California</option>
	<option value="CO">Colorado</option>
	<option value="CT">Connecticut</option>
	<option value="DE">Delaware</option>
	<option value="DC">District Of Columbia</option>
	<option value="FL">Florida</option>
	<option value="GA">Georgia</option>
	<option value="HI">Hawaii</option>
	<option value="ID">Idaho</option>
	<option value="IL">Illinois</option>
	<option value="IN">Indiana</option>
	<option value="IA">Iowa</option>
	<option value="KS">Kansas</option>
	<option value="KY">Kentucky</option>
	<option value="LA">Louisiana</option>
	<option value="ME">Maine</option>
	<option value="MD">Maryland</option>
	<option value="MA">Massachusetts</option>
	<option value="MI">Michigan</option>
	<option value="MN">Minnesota</option>
	<option value="MS">Mississippi</option>
	<option value="MO">Missouri</option>
	<option value="MT">Montana</option>
	<option value="NE">Nebraska</option>
	<option value="NV">Nevada</option>
	<option value="NH">New Hampshire</option>
	<option value="NJ">New Jersey</option>
	<option value="NM">New Mexico</option>
	<option value="NY">New York</option>
	<option value="NC">North Carolina</option>
	<option value="ND">North Dakota</option>
	<option value="OH">Ohio</option>
	<option value="OK">Oklahoma</option>
	<option value="OR">Oregon</option>
	<option value="PA">Pennsylvania</option>
	<option value="RI">Rhode Island</option>
	<option value="SC">South Carolina</option>
	<option value="SD">South Dakota</option>
	<option value="TN">Tennessee</option>
	<option value="TX">Texas</option>
	<option value="UT">Utah</option>
	<option value="VT">Vermont</option>
	<option value="VA">Virginia</option>
	<option value="WA">Washington</option>
	<option value="WV">West Virginia</option>
	<option value="WI">Wisconsin</option>
	<option value="WY">Wyoming</option>
</select>	<br />			
				
Request Note:<br /><textarea rows="10" cols="30" style="border-radius:5px;border: 2px solid #a62f03;"></textarea>
<input type="submit" value="Send">
<input type="reset" value="Reset">
<p color:#a62f03;">
<a href="about.html">About Us</a>|<a href="Advertise.html">Advertisement</a></p>
</form>
</div>
</body>
</html>  