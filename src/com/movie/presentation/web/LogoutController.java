package com.movie.presentation.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movie.service.UserService;

public class LogoutController implements Controller {
	private UserService userService;
	private String view;
	
	public LogoutController(UserService service, String view) {
		this.userService = service;
		this.view = view;
	}
	
	
	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		
		return view;
	}

}
