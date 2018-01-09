package com.sumathi.bookmyshow;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

import com.sumathi.moviedate.MovieDates;
import com.sumathi.movies.Movies;
import com.sumathi.movieseat.MovieSeating;
import com.sumathi.movietime.MovieTimings;
import com.sumathi.theatre.Theatres;

/**
 * Servlet implementation class MoviesDispaly
 */
@WebListener 
public class BookMyShowController extends HttpServlet {
	final static Logger logger = Logger.getLogger(BookMyShowController.class);
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void init(ServletConfig config) throws ServletException
	{
		System.out.println("git test.........");
		System.out.println("Git Test2..........");
		System.out.println("testing jenkins new........");
		/*String Log4jLocation=config.getInitParameter("log4j-properties-location");
		ServletContext context=config.getServletContext();
		if(Log4jLocation==null)
		{
			System.out.println("no log4j properties location found.");
			BasicConfigurator.configure();
		}
		else
		{
			String webAppPath=context.getRealPath("/");
			String log4jProp=webAppPath+Log4jLocation;
			System.out.println("Log4j properties file location:"+log4jProp);
			PropertyConfigurator.configure(log4jProp);
			}*/
		
		String Log4jLocation=config.getInitParameter("log4j-xml-location");
		ServletContext context=config.getServletContext();
		if(Log4jLocation==null)
		{
			System.out.println("no log4j xml location found.");
			BasicConfigurator.configure();
		}
		else
		{
			String webAppPath=context.getRealPath("/");
			String log4jProp=webAppPath+Log4jLocation;
			System.out.println("Log4j xml file location:"+log4jProp);
			DOMConfigurator.configure(log4jProp);
		}
		super.init(config);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Enter into main..........");
			
		logger.info("This is my first log4j's statement");
		logger.debug("this is log state,eny");
		logger.error("this is error message");
		
		String req=request.getParameter("req");
		System.out.println("Request:"+req);
		if(req.equalsIgnoreCase("movie"))
		{
		  displayMovies(request,response);
		}
		if(req.equalsIgnoreCase("theatre"))
		{
		    displayTheatres(request,response);
		}
		if(req.equalsIgnoreCase("date"))
		{
			displayMovieDates(request,response);
		}
		if(req.equalsIgnoreCase("time"))
		{
			displayMovieTimings(request,response);
		}
		if(req.equalsIgnoreCase("seat"))
		{
			displayMovieSeat(request,response);
		}
	}
	private void displayMovies(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("enter into displayMovies.......");
		Movies movies=new Movies();
		ArrayList list=movies.getMovies();
		request.setAttribute("movieList",list);
		request.getRequestDispatcher("/MoviesList.jsp").forward(request,response);	
	}
	
	private void displayTheatres(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("enter into displayTheatres.......");
		String MovieName=(String)request.getParameter("name");
		System.out.println("Movie name:"+MovieName);
		
		Theatres theatres=new Theatres();
		ArrayList list=theatres.getTheatres(MovieName);
		request.setAttribute("theatreList",list);
		request.getRequestDispatcher("/TheatreList.jsp").forward(request,response);	
	}
	private void displayMovieDates(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int movie_id=Integer.parseInt(request.getParameter("movie_id"));
		int theatre_id=Integer.parseInt(request.getParameter("theatre_id"));
		MovieDates dates=new MovieDates();
		ArrayList movieDatesList=dates.getMovieDates(movie_id, theatre_id);
		request.setAttribute("movieDatesList",movieDatesList);
		request.getRequestDispatcher("/ShowDates.jsp").forward(request,response);	
	}
	private void displayMovieTimings(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int movie_id = Integer.parseInt(request.getParameter("movie_id_time"));
		String show_date=request.getParameter("show_date");
		System.out.println("movie_id:in timimngs" + movie_id + "::" + show_date);

		MovieTimings movietimings=new MovieTimings();
		ArrayList movieTimeList=movietimings.getMovieTimings(movie_id,show_date);
		request.setAttribute("movieTimeList",movieTimeList);
		request.getRequestDispatcher("/ShowTimings.jsp").forward(request,response);	
	}
	private void displayMovieSeat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int show_id = Integer.parseInt(request.getParameter("show_id"));
	    System.out.println("show_id in seating:"+show_id);

		MovieSeating movieSeating=new MovieSeating();
		ArrayList movieSeatList=movieSeating.getMovieSeat(show_id);
		request.setAttribute("movieSeatList",movieSeatList);
		request.getRequestDispatcher("/Seating.jsp").forward(request,response);	
	}
	
}
