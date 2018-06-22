package com.jurik99.Singleton;

public class LazyInitializedSingleton {

	private static LazyInitializedSingleton instance;

	private LazyInitializedSingleton() {}

	public static LazyInitializedSingleton getInstance() {
		if (instance == null) {
			instance = new LazyInitializedSingleton();
		}
		return instance;
	}

	public static void main(final String[] args) {
		final LazyInitializedSingleton singleton = LazyInitializedSingleton.getInstance();
	}
}
