package com.jurik99.Singleton;

public class ThreadSafeSingleton_1 {

	private static ThreadSafeSingleton_1 instance;

	private ThreadSafeSingleton_1() {}

	public static ThreadSafeSingleton_1 getInstance() {
		if (instance == null) {
			synchronized (ThreadSafeSingleton_1.class) {
				instance = new ThreadSafeSingleton_1();
			}
		}
		return instance;
	}

	public static void main(final String[] args) {
		final ThreadSafeSingleton_1 singleton = ThreadSafeSingleton_1.getInstance();
	}
}
