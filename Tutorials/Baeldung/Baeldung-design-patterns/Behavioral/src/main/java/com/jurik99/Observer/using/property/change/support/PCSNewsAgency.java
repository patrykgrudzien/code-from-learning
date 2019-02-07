package com.jurik99.Observer.using.property.change.support;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class PCSNewsAgency {

	private String news;

	private PropertyChangeSupport support;

	public PCSNewsAgency() {
		this.support = new PropertyChangeSupport(this);
	}

	public void addPropertyChangeListener(final PropertyChangeListener listener) {
		this.support.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(final PropertyChangeListener listener) {
		this.support.removePropertyChangeListener(listener);
	}

	public void setNews(final String newValue) {
		this.support.firePropertyChange("news", this.news, newValue);
		this.news = newValue;
	}
}
