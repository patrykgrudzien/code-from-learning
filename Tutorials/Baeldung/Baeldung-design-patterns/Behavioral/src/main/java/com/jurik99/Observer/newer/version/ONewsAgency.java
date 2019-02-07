package com.jurik99.Observer.newer.version;

import java.util.Observable;

public class ONewsAgency extends Observable {

	private String news;

	public void setNews(final String news) {
		this.news = news;
		super.setChanged();
		super.notifyObservers(news);
	}
}
