<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<link rel="stylesheet" media="screen" type="text/css" href="css/denis_css/moviestyle.css">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Movie'S'tuff - Profile Page</title>
		<script src="scripts/jquery-1.10.2.js" type="text/javascript"></script>
		<script>
			function logout() {
				$.get("profile.html?logout=true");
			}
		
			function addFavActor() {
				var actor = document.getElementById("addActorField").value;
				$.get("profile.html?addActorField=" + actor);
				//manageForm.submit();
			}
			
			function addFavDirector() {
				var director = document.getElementById("addDirectorsField").value;
				$.get("profile.html?addDirectorsField=" + director);
			}
			
			function addFavProducer() {
				var producer = document.getElementById("addProducersField").value;
				$.get("profile.html?addProducersField=" + producer);
			}
			
			function changeUserName() {
				var newUsername = document.getElementById("newUsername").value;
				$.get("profile.html?newUsername=" + newUsername);
			}
			
			function changeEmail() {
				var newEmail = document.getElementById("newEmail").value;
				$.get("profile.html?newEmail=" + newEmail);
			}
			
			function changePassword() {
				var newPassword = document.getElementById("newPassword").value;
				$.get("profile.html?newPassword=" + newPassword);
			}
			
			function deleteFav() {
				var actor = this.value;
				$.get("profile.html?deleteActor=" + actor);
			}
		</script>
	</head>

	<body id="bod">
	<div id="wrapper">

		<img id="anim" src="pictures/title2.JPG" alt="website name" height="70" width="250" style="float:left;"/>
		<div id='menu'>
		<br />
		<nav>
			<ul>
				<div id="nav-bar">
			   <li ><a href="movie'S'tuff.html"><span>Home</span></a></li>
   			   <li><a href="movieNews.html"><span>News</span></a></li>
   				<li><a href="release.html"><span>Release Dates</span></a></li>
   				<li><a href="top.html"><span>Top Trending Movies</span></a></li>
   				<li class='active'><a href='profile.html'><span>Profile</span></a></li>
   				</div>
   				</ul>
   				</nav>
   			</div>
			   </div>
			
		
	</div>

	<div id="container">
	
	
	
<!--User's name-->
<div id="usr">
	<form id="logForm" action="logout.html">
			
			<span id="usrName"> <a href="profile.html"> ${user.name } </a> </span>			
			<input id="logoutButtonHome" type="submit" name="logoutButtonHome" value="Logout" />
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




<!--.............BIG TAB...............-->
<div class="bigTabs">
	<div class="bigTab">
		<input type="radio" id="manageFavoritesTab" name="bigTabGroup" checked>
		<label id="bigTag1" for="manageFavoritesTab"> Manage Favorites  </label>
		<div class="bigTabContent">
					
					<!--Tabs Actors, Directors ... --> 

					<div id="manageForm">
						<form id="manageForm" action="profile.html" method="post">

						
							<div class="tabs">
								<div class="tab">
									<input type="radio" id="actorsTab" name="tabGroup" checked>
									<label id="tag1" for="actorsTab"> Actors </label>
									<div class="tabContent">
										
										<input id="addActorField" type="text" name="addActorField" size="25" placeholder=" Actor"> 
										<input id="addButton" type="submit"  value="Add"><br /> <br /> 
										<span class="titleInTab">All your Favorite Actors</span> <br />
										<ul style="list-style-type:none">
											
											<c:forEach items="${actors }" var="actor">
												<li> <input type="image" src="pictures/del.jpg" name="deleteActor" class="delete" id="delButto" width="15" height="15" value="${actor }"> ${actor}</li> <br />
											</c:forEach>
										</ul>
										
									</div>
								</div>
								<div class="tab">
									<input type="radio" id="directorsTab" name="tabGroup">
									<label id="tag2" for="directorsTab"> Directors </label>
									<div class="tabContent">
										<input id="addDirectorsField" name="addDirectorsField" type="text" size="25" placeholder=" Director"> 
										<input id="addButton" type="submit" value="Add"> <br /> <br />
										<span class="titleInTab">All your favorite Directors</span> <br />
										<ul style="list-style-type:none">
											
											<c:forEach items="${directors }" var="director">
												<li> <input type="image" src="pictures/del.jpg" name="deleteDirector" class="delete" id="delButto" width="15" height="15" value="${director }"> ${director}</li> <br />
											</c:forEach>
										</ul>
										
									</div>
								</div>
								<div class="tab">
									<input type="radio" id="writersTab" name="tabGroup">
									<label id="tag3" for="writersTab"> Scenario Writers </label>
									<div class="tabContent">
										<input id="addProducersField" name="addProducersField" type="text" size="25" placeholder=" Scenario Writer"> 
										<input id="addButton" type="submit" value="Add"> <br /> <br />
										<span class="titleInTab">All your favorite Scenario Writers</span> <br />
										<ul style="list-style-type:none">
											
											<c:forEach items="${producers }" var="producer">
												<li> <input type="image" src="pictures/del.jpg" name="deleteProducer" class="delete" id="delButto" width="15" height="15" value="${producer }"> ${producer}</li> <br />
											</c:forEach>
										</ul>
										
									</div>
								</div>
								<div class="tab">
									<input type="radio" id="studiosTab" name="tabGroup">
									<label id="tag4" for="studiosTab"> Studios </label>
									<div class="tabContent">
										<input id="addField" type="text" size="25" placeholder=" Studio"> 
										<input id="addButton" type="button" onclick="addFav();" value="Add"> <br /> <br />
										<span class="titleInTab">All your favorite Studios</span> <br />
										
									</div>
								</div>
								<div class="tab">
									<input type="radio" id="genresTab" name="tabGroup">
									<label id="tag5" for="genresTab"> Film Genres </label>
									<div class="tabContent">
										<input id="addField" type="text" size="25" placeholder=" Film Genre"> 
										<input id="addButton" type="button" onclick="addFav();" value="Add"> <br /> <br />
										<span class="titleInTab">All your favorite Film Genres</span> <br />
										
									</div>
								</div>
								
							</div>
						</form>
					</div>

			</div>
		</div>



			<!-- ..............Account Settings ................-->
		<br /> <br />
		<div class="bigTab">
		<input type="radio" id="accSettingsTab" name="bigTabGroup" >
		<label id="bigTag2" for="accSettingsTab"> Account Settings </label>
			
			<div class="bigTabContent">
			<form id="accountSettingsForm" action="profile.html" method="post">
			<span class="titleInTab">Change you Username</span> <br />
			Your new username <br />
			<input type="text" id="newUsername" name="newUsername"/> <br /> 
			<input type="submit" id="applyUserName" value = "Apply"/><br /> <br />   

			<span class="titleInTab">Change your Email Address</span> <br />
			Your current email address is <span> ${user.email} </span> <br />
			Your new email address <br />
			<input type="text" id="newEmail" name="newEmail"/> <br />
			Please re-type your new email address <br />
			<input type="text" id="newEmailRetype" name="newEmailRetype"/> <br />
			<input type="submit" id="applyEmail" value = "Apply"/>
			<br /> <br />

			<span class="titleInTab">Change your Password</span> <br />
			Your new password <br />
			<input type="password" id="newPassword" name="newPassword"/> <br />
			Please re-type your new password <br />
			<input type="password" id="newPasswordRetype" name="newPasswordRetype"/> <br />
			<input type="submit" id="applyPassword" value = "Apply"/>
			</form>
			</div>
		</div>


			<!-- ..............Notifications Settings ................-->
		<!--
		<br /> <br /> <br />
		<div class="bigTab">
		<input type="radio" id="notSettingsTab" name="bigTabGroup" >
		<label for="notSettingsTab"> Notification Settings </label>
			Notifications Settings
			</div>
		</div>
		-->


<br /><br /><br /><br /><br /><br /><br />
<br />
</div>
</body>
</html>  