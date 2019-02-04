package com.jurik99.Bridge;

public abstract class Shape {

	Color color;

	Shape(final Color color) {
		this.color = color;
	}

	public abstract String draw();

}
