package com.jurik99.Bridge;

/**
 * The official definition for Bridge design pattern is to decouple an abstraction from its implementation so that the two can vary independently.
 * This means to create a bridge interface that uses OOP principles to separate out responsibilities into different abstract classes.
 *
 * For the Bridge pattern, we'll consider 2 layers of abstraction:
 * 1) One is the geometric shape (like triangle and square) which is:
 * 2) Filled with different colors (out second abstraction layer)
 */
public abstract class Shape {

	Color color;

	Shape(final Color color) {
		this.color = color;
	}

	public abstract String draw();

}
