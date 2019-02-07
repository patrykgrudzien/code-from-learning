package com.jurik99.Observer.using.property.change.support;

public class MainBest {

	public static void main(final String[] args) {

		final PCSNewsAgency observable = new PCSNewsAgency();
		final PCSNewsChannel observer = new PCSNewsChannel();

		observable.addPropertyChangeListener(observer);
		observable.setNews("news");

		System.out.println(observer.getNews());
	}
}
