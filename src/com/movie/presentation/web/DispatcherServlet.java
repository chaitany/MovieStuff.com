package com.movie.presentation.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.config.MovieConfig;
import com.movie.service.UserService;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserService userService;
	
	// controllers
	private IndexController indexController;
	private SigninController signinController;
	private RegistrationController registrationController;
	private ProfileController profileController;
	private NewsController newsController;
	private ReleaseDatesController releaseDatesController;
	private TrendingController trendingController;
	private AboutController aboutController;
	private AdvertiseController advertiseController;
	private LogoutController logoutController;
	
	// url strings
	protected static final String HOME_URL = "/WEB-INF/jsp/movies'S'tuff.jsp";
	protected static final String INDEX_URL = "/WEB-INF/jsp/movies'S'tuff.jsp";
	protected static final String SIGNIN_URL = "/WEB-INF/jsp/signin.jsp";
	protected static final String PROFILE_URL = "/WEB-INF/jsp/profile.jsp";
	protected static final String NEWS_URL = "/WEB-INF/jsp/movieNews.jsp";
	protected static final String RELEASE_DATE_URL = "/WEB-INF/jsp/release.jsp";
	protected static final String TRENDING_URL = "/WEB-INF/jsp/top.jsp";
	protected static final String ABOUT_URL = "/WEB-INF/jsp/about.jsp";
	protected static final String ADVERTISE_URL = "/WEB-INF/jsp/advertise.jsp";
	
    /**
     * Default constructor. 
     */
    public DispatcherServlet() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	// intialize service
    	MovieConfig.configureServices();
    	userService = MovieConfig.getUserService();
    	// create controllers
    	indexController = new IndexController(userService, INDEX_URL);
    	signinController = new SigninController(userService, SIGNIN_URL);
    	registrationController = new RegistrationController(userService, PROFILE_URL);
    	profileController =  new ProfileController(userService, PROFILE_URL);
    	newsController = new NewsController(userService, NEWS_URL);
    	releaseDatesController = new ReleaseDatesController(userService, RELEASE_DATE_URL);
    	trendingController = new TrendingController(userService, TRENDING_URL);
    	aboutController = new AboutController(userService, ABOUT_URL);
    	advertiseController = new AdvertiseController(userService, ADVERTISE_URL);
    	logoutController = new LogoutController(userService, SIGNIN_URL);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURL = request.getServletPath(); 
		System.out.println("DispatcherServlet: requestURL = " + requestURL);
		String forwardURL = null;
		if (requestURL.equals("/home.html")) {
			forwardURL = HOME_URL;
		}
		else if (requestURL.equals("/movie\'S\'tuff.html") || requestURL.equals("/index.html")) {
			forwardURL = indexController.handleRequest(request, response);
		}
		else if (requestURL.equals("/signin.html")) {
			forwardURL = signinController.handleRequest(request, response);
		}
		else if (requestURL.equals("/register.html")) {
			forwardURL = registrationController.handleRequest(request, response);
		}
		else if (requestURL.equals("/profile.html")) {
			forwardURL = profileController.handleRequest(request, response);
		}
		else if (requestURL.equals("/movieNews.html")) {
			forwardURL = newsController.handleRequest(request, response);
		}
		else if (requestURL.equals("/release.html")) {
			forwardURL = releaseDatesController.handleRequest(request, response);
		}
		else if (requestURL.equals("/top.html")) {
			forwardURL = trendingController.handleRequest(request, response);
		}
		else if (requestURL.equals("/about.html")) {
			forwardURL = aboutController.handleRequest(request, response);
		}
		else if (requestURL.equals("/Advertise.html")) {
			forwardURL = advertiseController.handleRequest(request, response);
		}
		else if (requestURL.equals("/logout.html")) {
			forwardURL = logoutController.handleRequest(request, response);
		}
		else 
			throw new ServletException("DispatcherServlet: Unknown servlet path: "
					+ requestURL);
		System.out.println("DispatcherServlet: forwarding to "+ forwardURL);
		
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher(forwardURL);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
