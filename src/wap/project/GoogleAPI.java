package wap.project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wap.project.TrendingTweets;
import twitter4j.TwitterException;

/**
 * Servlet implementation class GooogleAPI
 */
@WebServlet("/GoogleAPI")
public class GoogleAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoogleAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Inside doGet");
		response.setContentType("application/json");
	
		// TODO Auto-generated method stub
		TrendingTweets get_Trending_Tweets = new TrendingTweets(); 
		PrintWriter out = response.getWriter();
		String country_name =request.getParameter("country");
	
		if(country_name!= null)
		{
			try {
				//System.out.println("inside try servlet " + get_Trending_Tweets.getLocationTweets(country_name));
				out.write(get_Trending_Tweets.getLocationTweets(country_name));
			} catch (TwitterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
		}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
