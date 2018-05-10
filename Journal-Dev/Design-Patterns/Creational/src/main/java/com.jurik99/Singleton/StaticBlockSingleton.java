package com.jurik99.Singleton;

public class StaticBlockSingleton {

	private static StaticBlockSingleton instance;

	private StaticBlockSingleton() {}

	// static block initialization for exception handling
	static {
		try {
			instance = new StaticBlockSingleton();
		} catch (final Exception e) {
			throw new RuntimeException("Exception occured in creating singleton instance!");
		}
	}

	public static StaticBlockSingleton getInstance() {
		return instance;
	}

	public static void main(final String[] args) {
		final StaticBlockSingleton singleton = StaticBlockSingleton.getInstance();
	}
}
