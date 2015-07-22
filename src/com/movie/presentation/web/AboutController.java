package com.movie.presentation.web;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.feedutil.FeedObject;
import com.movie.service.UserService;

public class AboutController implements Controller {
	private UserService userService;
	private String view;
	
	public AboutController(UserService service, String view) {
		this.userService = service;
		this.view = view;
	}
	
	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		
		return view;
	}

}
