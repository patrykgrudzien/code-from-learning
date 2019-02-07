package com.jurik99.Observer.older.version;

/**
 * Observer is a behavioral design pattern. It specifies communication between objects: observable and observers.
 * An observable is an object which notifies observers about the changes in its state.
 *
 * For example, a news agency can notify channels when it receives news. Receiving news is what changes the state of the news agency, and it causes the channels to be
 * notified.
 */
public class MainOld {

	public static void main(final String[] args) {

		final NewsAgency observable = new NewsAgency();
		final NewsChannel observer = new NewsChannel();

		observable.addObservers(observer);
		observable.setNews("News");

		System.out.println(observer.getNews());
	}
}
