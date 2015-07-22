package com.movie.presentation.web;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.spi.XmlReader;

import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;

public class HomeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private Logger logger = Logger.getLogger(this.getClass());
	private RequestDispatcher homeJsp;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {/*
		logger.debug("Retrieving boston weather news feed");
		URL url = new URL("http://www.movies.com/rss-feeds/dave-white-reviews-rss");
		SyndFeedInput syndFeedInput = new SyndFeedInput();
		SyndFeed syndFeed = null;
		XmlReader xmlReader = new XmlReader(url);
		try {
			syndFeed = syndFeedInput.build(xmlReader);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			logger.error("", e);
		} catch (FeedException e) {
			// TODO Auto-generated catch block
			logger.error("", e);
		}
		logger.debug("Forwarding to home.jsp");
		req.setAttribute("syndFeed", syndFeed);
		homeJsp.forward(req, resp);*/
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		ServletContext context = config.getServletContext();
		homeJsp = context.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
	}

}
