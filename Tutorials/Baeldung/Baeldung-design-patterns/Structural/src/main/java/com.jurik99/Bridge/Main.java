package com.jurik99.Bridge;

/**
 * The official definition for Bridge design pattern is to decouple an abstraction from its implementation so that the two can vary independently.
 * This means to create a bridge interface that uses OOP principles to separate out responsibilities into different abstract classes.
 *
 * For the Bridge pattern, we'll consider 2 layers of abstraction:
 * 1) One is the geometric shape (like triangle and square) which is:
 * 2) Filled with different colors (out second abstraction layer)
 *
 * The Bridge pattern is an application of the old advice, "prefer composition over inheritance".
 * It becomes handy when you must subclass different times in ways that are orthogonal with one another.
 * Say you must implement a hierarchy of colored shapes.
 * You wouldn't subclass Shape with Rectangle and Circle and then subclass Rectangle with RedRectangle, BlueRectangle and GreenRectangle and the same for Circle, would you?
 * You would prefer to say that each Shape has a Color and to implement a hierarchy of colors, and that is the Bridge Pattern.
 * Well, I wouldn't implement a "hierarchy of colors"
 */
public class Main {

	public static void main(final String[] args) {

		// a square with red color
		final Shape square = new Square(new Blue());
		System.out.println("square.draw() = " + square.draw());
	}
}
