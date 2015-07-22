package com.movie.presentation.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movie.domain.User;
import com.movie.service.UserService;

public class SigninController implements Controller {
	private UserService userService;
	private String view;
	
	public SigninController(UserService service, String view) {
		this.userService = service;
		this.view = view;
	}
	

	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		
		String userPass = request.getParameter("passwordHome");
		String userName = request.getParameter("userNameHome");
		
		if (userPass != null && userName != null) {
			User user = userService.checkLogin(userName, userPass);
			user.printUser();
			if (user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				view = DispatcherServlet.PROFILE_URL;
			}
		}
		return view;
	}

}
