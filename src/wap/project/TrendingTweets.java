package wap.project;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;

import twitter4j.Location;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Trend;
import twitter4j.Trends;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TrendingTweets {
	private List<String> trending_hashtag = new ArrayList<>();

	public String getLocationTweets(String country) throws TwitterException {

		try {

			ConfigurationBuilder cf = new ConfigurationBuilder();
			cf.setDebugEnabled(true).setOAuthConsumerKey("*********************")
					.setOAuthConsumerSecret("**************************************************")
					.setOAuthAccessToken("*************************************************")
					.setOAuthAccessTokenSecret("**********************************************");

			TwitterFactory tf = new TwitterFactory(cf.build());
			twitter4j.Twitter twitter = tf.getInstance();

			ResponseList<Location> locations;
			locations = twitter.getAvailableTrends();

			Integer idTrendLocation = getTrendLocationId(country);

			if (idTrendLocation == null) {
				System.out.println("Trend Location Not Found");
				System.exit(0);
			}

			// appending the values to the list of the country name
			Trends trends = twitter.getPlaceTrends(idTrendLocation);
			for (int i = 0; i < trends.getTrends().length; i++) {
				trending_hashtag.add("" + trends.getTrends()[i].getName());
				//System.out.println(trends.getTrends()[i].getName());
			}

			//System.exit(0);

		} catch (TwitterException te) {
			te.printStackTrace();
			System.out.println("Failed to get trends: " + te.getMessage());
			System.exit(-1);
		}
		
		//System.out.println();
		return new Gson().toJson(trending_hashtag);
	}

	private Integer getTrendLocationId(String locationName) {

		int idTrendLocation = 0;

		try {

			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true).setOAuthConsumerKey("*************************")
					.setOAuthConsumerSecret("***************************************************")
					.setOAuthAccessToken("*************************************************")
					.setOAuthAccessTokenSecret("***********************************************");

			TwitterFactory tf = new TwitterFactory(cb.build());
			Twitter twitter = tf.getInstance();

			ResponseList<Location> locations;
			locations = twitter.getAvailableTrends();

			for (Location location : locations) {
				if (location.getName().toLowerCase().equals(locationName.toLowerCase())) {
					idTrendLocation = location.getWoeid();
					break;
				}
			}

			if (idTrendLocation > 0) {
				return idTrendLocation;
			}

			return null;

		} catch (TwitterException te) {
			te.printStackTrace();
			System.out.println("Failed to get trends: " + te.getMessage());
			return null;
		}

	}

}