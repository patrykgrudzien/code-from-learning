package com.jurik99.Observer.older.version;

public class NewsChannel implements Channel {

	private String news;

	@Override
	public void update(final Object news) {
		this.setNews((String) news);
	}

	public String getNews() {
		return news;
	}

	public void setNews(final String news) {
		this.news = news;
	}
}
