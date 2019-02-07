package com.jurik99.Observer.using.property.change.support;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PCSNewsChannel implements PropertyChangeListener {

	private String news;

	@Override
	public void propertyChange(final PropertyChangeEvent evt) {
		this.setNews((String) evt.getNewValue());
	}

	public String getNews() {
		return news;
	}

	public void setNews(final String news) {
		this.news = news;
	}
}
