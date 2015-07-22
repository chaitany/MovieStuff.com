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

public class NewsController implements Controller {
	private UserService userService;
	private String view;
	private LinkedList<FeedObject> feedItems;
	
	public NewsController(UserService service, String view) {
		this.userService = service;
		this.view = view;
		feedItems = new LinkedList<FeedObject>();
	}

	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		System.out.println(request.getParameter("searchTerm"));
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String searchTerm = request.getParameter("searchTerm");
		System.out.println(searchTerm);

		URL url1 = new URL("http://www.fandango.com/rss/movie-news.rss");
		URL url2 = new URL("http://www.cinemablend.com/rss.php");	
		FeedAssembler assembler = new FeedAssembler();
		
		LinkedList<FeedObject> additionalItems = new LinkedList<FeedObject>();
		
		if (searchTerm != null) {
			int count = 0;
			feedItems = assembler.getFeedItems(url2, searchTerm);
			additionalItems = assembler.getFeedItems(url1, searchTerm);
			for (FeedObject fo : additionalItems) {
				feedItems.add(fo);
				count++;
				if (count > 17)
					break;
			}
		}
		else if (user != null) {
			HashSet<String> preferences = userService.getUserPreferences(user);
			int count = 0;
			feedItems = assembler.getFeedItems(url2, preferences);
			additionalItems = assembler.getFeedItems(url1, preferences);
			for (FeedObject fo : additionalItems) {
				feedItems.add(fo);
				count++;
				if (count > 17)
					break;
			}
		}
		else {
			feedItems = assembler.getFeedItems(url2);
		}
		
		request.setAttribute("feedItems", feedItems);
		return view;
	}

}
