package com.movie.presentation.web;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movie.domain.User;
import com.movie.service.UserService;

public class ProfileController implements Controller {
	private UserService userService;
	private String view;
	
	public ProfileController(UserService service, String view) {
		this.userService = service;
		this.view = view;
	}
	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		System.out.println(request.getQueryString());
		
		if (request.getParameter("logoutButtonHome") != null) {
			//user = null;
			session.removeAttribute("user");
			//session.setAttribute("user", null);
			view =  "/WEB-INF/jsp/signin.jsp";//DispatcherServlet.SIGNIN_URL;
			return view;
		}
		
		// insert all new values to favorites
		String actorToAdd = request.getParameter("addActorField");
		if (actorToAdd != null && !actorToAdd.equals("")) {
			userService.addFavActor(user.getName(), actorToAdd);
		}
		
		String directorToAdd = request.getParameter("addDirectorsField");
		if (directorToAdd != null && !directorToAdd.equals("")) {
			userService.addFavDirector(user.getName(), directorToAdd);
		}
		
		String producerToAdd = request.getParameter("addProducersField");
		if (producerToAdd != null && !producerToAdd.equals("")) {
			userService.addFavProducer(user.getName(), producerToAdd);
		}
		
		String actorToDelete = request.getParameter("deleteActor");
		if (actorToDelete != null && !actorToDelete.equals("")) {
			userService.deleteActor(user, actorToDelete);
		}
		
		String directorToDelete = request.getParameter("deleteDirector");
		if (directorToDelete != null && !directorToDelete.equals("")) {
			userService.deleteDirector(user, directorToDelete);
		}
		
		String producerToDelete = request.getParameter("deleteProducer");
		if (producerToDelete != null && !producerToDelete.equals("")) {
			userService.deleteProducer(user, producerToDelete);
		}
		
		LinkedList<String> actors = userService.getFavActors(user.getName());
		request.setAttribute("actors", actors);
		LinkedList<String> producers = userService.getFavProducers(user.getName());
		request.setAttribute("producers", producers);
		LinkedList<String> directors = userService.getFavDirectors(user.getName());
		request.setAttribute("directors", directors);
		
		// change account settings
		String newUsername = request.getParameter("newUsername");
		if (newUsername != null && !newUsername.equals("")) {
			userService.updateUsername(user, newUsername);
			user = userService.getUserByName(newUsername);
		}
		
		String newEmail = request.getParameter("newEmail");
		if (newEmail != null && !newEmail.equals("")) {
			userService.updateEmail(user, newEmail);
			user.setEmail(newEmail);
			//user = userService.getUserByEmail(newEmail);
			//session.setAttribute("user", user);
		}
		
		String newPassword = request.getParameter("newPassword");
		if (newPassword != null && !newPassword.equals("")) {
			userService.updatePassword(user, newPassword);
			user = userService.getUserByName(user.getName());
		}
		
		return view;
	}

}
