package com.movie.presentation.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movie.domain.User;
import com.movie.service.UserService;

public class RegistrationController implements Controller {
	private UserService userService;
	private String view;
	
	public RegistrationController(UserService service, String view) {
		this.userService = service;
		this.view = view;
	}

	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		
		String userEmail = request.getParameter("email");
		String userPass = request.getParameter("password");
		String userName = request.getParameter("userName");
		
		// try to find user in db, if not present, insert a new one
		User user = userService.checkLogin(userName, userPass);
		if (user == null) {
			if (userEmail == null)
				return view;
			boolean success = userService.insertUser(userName, userPass, userEmail);
			if (!success) {
				// TODO add some user error notification logic
			}
			user = userService.getUserByEmail(userEmail);
		}
		user.printUser();
		
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		
		return view;
	}

}
