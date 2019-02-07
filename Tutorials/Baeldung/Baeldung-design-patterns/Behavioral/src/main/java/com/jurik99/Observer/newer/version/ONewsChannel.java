package com.jurik99.Observer.newer.version;

import java.util.Observable;
import java.util.Observer;

public class ONewsChannel implements Observer {

	private String news;

	@Override
	public void update(final Observable o, final Object arg) {
		this.setNews((String) arg);
	}

	public String getNews() {
		return news;
	}

	public void setNews(final String news) {
		this.news = news;
	}
}
