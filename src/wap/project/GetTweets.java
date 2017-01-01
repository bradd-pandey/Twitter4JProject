package wap.project;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.TwitterFactory;
import twitter4j.Query;
import twitter4j.QueryResult;

public class GetTweets {

	public GetTweets() {
		// TODO Auto-generated constructor stub
	}

	public static String acceptTweet(String searchedKeyword) throws TwitterException {
		ConfigurationBuilder configBuilder = new ConfigurationBuilder();
		configBuilder.setDebugEnabled(true).setOAuthConsumerKey("N85Vk5B0RwWLovop0610E9ZoN")
				.setOAuthConsumerSecret("NCfT9215bBpoSBshY30BLuWy61Wdc38twDlXUyQ7bNq4LFRird")
				.setOAuthAccessToken("486627451-eChtLwt41QFURzq5q6byIUUcE4N1tkX2pgUs8MSI")
				.setOAuthAccessTokenSecret("kC2pb5CqdDqPyt4Ot8xXkfyj25Rbqiq3UwXNpx80t8ek4");
		TwitterFactory tweeterFactory = new TwitterFactory(configBuilder.build());
		twitter4j.Twitter twitter = tweeterFactory.getInstance();

		List<Status> tweets;
		List<MyStatus> myStatusList = new ArrayList<MyStatus>();

		String imageURL, text, link;
		int count = 0;

		if (searchedKeyword.equals("seetrends")) {
			tweets = twitter.getHomeTimeline();
		}else {
			Query query = new Query(searchedKeyword);
			QueryResult queryResult;
			queryResult = twitter.search(query);
			tweets = queryResult.getTweets();
		}
		
		for (Status tweet : tweets) {
			if (tweet.getMediaEntities().length > 0) {
				imageURL = tweet.getMediaEntities()[0].getMediaURL();
				text = tweet.getText().substring(0, tweet.getText().indexOf("https")).toUpperCase();
				link = tweet.getMediaEntities()[0].getURL();
				MyStatus myStatus = new MyStatus(imageURL, text, link);
				myStatusList.add(myStatus);
				count++;
			}
			if (count > 10) {
				break;
			}
		}
		return new Gson().toJson(myStatusList);
	}
}