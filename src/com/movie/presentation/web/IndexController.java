package com.movie.presentation.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.service.UserService;

public class IndexController implements Controller {
	private UserService userService;
	private String view;
	
	public IndexController(UserService service, String view) {
		this.userService = service;
		this.view = view;
	}

	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		return view;
	}

}
