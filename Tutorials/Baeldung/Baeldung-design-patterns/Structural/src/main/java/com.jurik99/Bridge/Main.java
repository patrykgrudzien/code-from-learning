package com.jurik99.Bridge;

public class Main {

	public static void main(final String[] args) {

		// a square with red color
		final Shape square = new Square(new Blue());
		System.out.println("square.draw() = " + square.draw());
	}
}
