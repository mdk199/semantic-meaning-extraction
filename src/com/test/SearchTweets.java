package com.test;

import twitter4j.*;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

import java.util.Date;
import java.util.List;

/**
 * @author Yusuke Yamamoto - yusuke at mac.com
 * @since Twitter4J 2.1.7
 */
public class SearchTweets {
    /**
     * Usage: java twitter4j.examples.search.SearchTweets [query]
     *
     * @param args search query
     * @throws TwitterException 
     */
    public static void main(String[] args){
    	ConfigurationBuilder cb = new ConfigurationBuilder();
    	cb.setDebugEnabled(true);
    	cb.setOAuthConsumerKey("epG902Q6nYvtOlBAhf7l7Fn0Q");
    	cb.setOAuthConsumerSecret("2QDh5Gm3KdxVGUIhyKfBjlggykjPWnwl2aiyxW6SePwe5Sc10C");
    	cb.setOAuthAccessToken("3237627967-QoInapG4rI4SKeIPMPknNjkFQ52SG1zI2t0ROvy");
    	cb.setOAuthAccessTokenSecret("xtkKUqN3uL4WZfltM3KwXEr6NE37SS3r8gFXQ0QUZef9A");
        
    	
    	if (args.length < 1) {
            System.out.println("java twitter4j.examples.search.SearchTweets [query]");
            System.exit(-1);
        }
    	TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
           
        try {
            Query query = new Query("deepika padukone");
            query.since("2015-06-06");
            QueryResult result;
            do {
                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
                for (Status tweet : tweets) {
                    System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
                }
            } while ((query = result.nextQuery()) != null);
            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
        }
    }
}
