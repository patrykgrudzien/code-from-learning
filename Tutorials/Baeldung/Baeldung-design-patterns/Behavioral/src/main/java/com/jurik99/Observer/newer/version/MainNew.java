package com.jurik99.Observer.newer.version;

/**
 * The {@link java.util.Observer} interface defines the {@link java.util.Observer#update(java.util.Observable, Object)} method,
 * so there’s no need to define it ourselves as we did in the previous section.
 */
public class MainNew {

	public static void main(final String[] args) {

		final ONewsAgency observable = new ONewsAgency();
		final ONewsChannel observer = new ONewsChannel();

		observable.addObserver(observer);
		observable.setNews("News");

		System.out.println(observer.getNews());

		/**
		 * Observer interface isn’t perfect and is deprecated since Java 9. One of its cons is that Observable isn’t an interface but a class, that’s why subclasses
		 * can’t be used as observables.
		 *
		 * Also, a developer could override some of the Observable‘s synchronized methods and disrupt their thread-safety.
		 *
		 * Let’s look at the {@link java.beans.PropertyChangeSupport} interface, which is recommended
		 * instead of using {@link java.util.Observer}.
		 */
	}
}
