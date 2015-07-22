package com.movie.feedutil;

import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

import org.apache.log4j.Logger;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

public class FeedAssembler {
	private Logger logger = Logger.getLogger(this.getClass());
	
	public LinkedList<FeedObject> getFeedItems(URL url) {
		LinkedList<FeedObject> feedItems = new LinkedList<FeedObject>();
		
		SyndFeedInput syndFeedInput = new SyndFeedInput();
		SyndFeed syndFeed = null;
		try {
			XmlReader xmlReader = new XmlReader(url);
			syndFeed = syndFeedInput.build(xmlReader);
		} catch (IllegalArgumentException e) {
			System.out.println("Illegal Argument Exception caught");
			logger.error("", e);
		} catch (FeedException e) {
			System.out.println("Feed Exception Caught");
			logger.error("", e);
		} catch (Exception e) {
			logger.error("", e);
		}
		
		
		Iterator it = syndFeed.getEntries().iterator();
		while (it.hasNext()) {
			SyndEntry entry = (SyndEntry) it.next();
			FeedObject feedItem = new FeedObject();
			feedItem.setTitle(entry.getTitle());
			System.out.println(feedItem.getTitle());
			if (!url.toString().equals("http://www.fandango.com/rss/top10boxoffice.rss"))
				feedItem.setDescription(entry.getDescription().getValue());
			feedItem.setLinkUrl(entry.getLink());
			feedItems.add(feedItem);
		}
		return feedItems;
	}
	
	/**
	 * finds feed items based on user preferences
	 * @param url
	 * @param preferences
	 * @return
	 */
	public LinkedList<FeedObject> getFeedItems(URL url, HashSet<String> preferences) {
		LinkedList<FeedObject> feedItems = new LinkedList<FeedObject>();
		
		SyndFeedInput syndFeedInput = new SyndFeedInput();
		SyndFeed syndFeed = null;
		try {
			XmlReader xmlReader = new XmlReader(url);
			syndFeed = syndFeedInput.build(xmlReader);
		} catch (IllegalArgumentException e) {
			System.out.println("Illegal Argument Exception caught");
			logger.error("", e);
		} catch (FeedException e) {
			System.out.println("Feed Exception Caught");
			logger.error("", e);
		} catch (Exception e) {
			logger.error("", e);
		}
		
		
		Iterator it = syndFeed.getEntries().iterator();
		while (it.hasNext()) {
			SyndEntry entry = (SyndEntry) it.next();
			boolean match = false;
			for (String pref : preferences) {
				if (entry.getTitle().contains(pref) || entry.getDescription().getValue().contains(pref)
						|| entry.getLink().contains(pref)) {
					match = true;
					break;
				}
			}
			if (match) {
				FeedObject feedItem = new FeedObject();
				feedItem.setTitle(entry.getTitle());
				feedItem.setDescription(entry.getDescription().getValue());
				feedItem.setLinkUrl(entry.getLink());
				feedItems.add(feedItem);
			}
		}
		return feedItems;
	}
	
	/**
	 * finds feed items based on a search term
	 * @param url
	 * @param searchTerm
	 * @return
	 */
	public LinkedList<FeedObject> getFeedItems(URL url, String searchTerm) {
		LinkedList<FeedObject> feedItems = new LinkedList<FeedObject>();
		
		SyndFeedInput syndFeedInput = new SyndFeedInput();
		SyndFeed syndFeed = null;
		try {
			XmlReader xmlReader = new XmlReader(url);
			syndFeed = syndFeedInput.build(xmlReader);
		} catch (IllegalArgumentException e) {
			System.out.println("Illegal Argument Exception caught");
			logger.error("", e);
		} catch (FeedException e) {
			System.out.println("Feed Exception Caught");
			logger.error("", e);
		} catch (Exception e) {
			logger.error("", e);
		}
		
		
		Iterator it = syndFeed.getEntries().iterator();
		while (it.hasNext()) {
			SyndEntry entry = (SyndEntry) it.next();
			boolean match = false;
			if (entry.getTitle().contains(searchTerm) || entry.getDescription().getValue().contains(searchTerm)
						|| entry.getLink().contains(searchTerm)) {
				match = true;
			}
			if (match) {
				FeedObject feedItem = new FeedObject();
				feedItem.setTitle(entry.getTitle());
				feedItem.setDescription(entry.getDescription().getValue());
				feedItem.setLinkUrl(entry.getLink());
				feedItems.add(feedItem);
			}
		}
		return feedItems;
	}
}
