package com.jurik99.Bridge;

public class Square extends Shape {

	Square(final Color color) {
		super(color);
	}

	@Override
	public String draw() {
		return "Square drawn. " + color.fill();
	}
}
