package com.jurik99.Observer.older.version;

import java.util.ArrayList;
import java.util.List;

/**
 * NewsAgency is an observable, and when news gets updated, the state of NewsAgency changes. When the change happens, NewsAgency notifies the observers about this fact
 * by calling their update() method.
 *
 * To be able to do that, the observable object needs to keep references to the observers, and in our case, it’s the channels variable.
 */
public class NewsAgency {

	private String news;
	private List<Channel> channels = new ArrayList<>();

	public void addObservers(final Channel channel) {
		this.channels.add(channel);
	}

	public void removeObserver(final Channel channel) {
		this.channels.remove(channel);
	}

	public void setNews(final String news) {
		this.news = news;
		channels.forEach(channel -> channel.update(news));
	}
}
