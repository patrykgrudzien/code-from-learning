package com.jurik99.Flyweight;

import javax.annotation.concurrent.Immutable;

import java.awt.Color;

@Immutable
public final class Car implements Vehicle {

	private final Engine engine;
	private final Color color;

	Car(final Engine engine, final Color color) {
		this.engine = engine;
		this.color = color;

		try {
			System.out.println("Building new car...");
			// Building a new car is a very expensive operation!
			Thread.sleep(2000);
		} catch (final InterruptedException e) {
			System.out.println("Error while creating a new car... " + e.getMessage());
		}
	}

	@Override
	public void start() {
		System.out.println("Car is starting!");
		engine.start();
	}

	@Override
	public void stop() {
		System.out.println("Car is stopping!");
		engine.stop();
	}

	@Override
	public Color getColor() {
		return this.color;
	}
}
