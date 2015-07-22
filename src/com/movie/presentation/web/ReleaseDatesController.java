package com.movie.presentation.web;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movie.domain.User;
import com.movie.feedutil.FeedAssembler;
import com.movie.feedutil.FeedObject;
import com.movie.service.UserService;

public class ReleaseDatesController implements Controller {
	private UserService userService;
	private String view;
	private LinkedList<FeedObject> feedItems;
	
	public ReleaseDatesController(UserService service, String view) {
		this.userService = service;
		this.view = view;
		feedItems = new LinkedList<FeedObject>();
	}
	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		
		URL url = new URL("http://i.rottentomatoes.com/syndication/rss/upcoming.xml");		
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String searchTerm = request.getParameter("searchTerm");

		
		FeedAssembler assembler = new FeedAssembler();
		
		if (searchTerm != null) {
			feedItems = assembler.getFeedItems(url, searchTerm);
		}
		else if (user != null) {
			HashSet<String> preferences = userService.getUserPreferences(user);
			feedItems = assembler.getFeedItems(url, preferences);
		}
		else {
			feedItems = assembler.getFeedItems(url);
		}
		
		request.setAttribute("feedItems", feedItems);
		return view;
	}
}
