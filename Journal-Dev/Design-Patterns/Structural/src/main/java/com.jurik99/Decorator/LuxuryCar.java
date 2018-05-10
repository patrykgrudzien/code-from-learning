package com.jurik99.Decorator;

public class LuxuryCar extends CarDecorator {

	public LuxuryCar(final Car car) {
		super(car);
		System.out.println("LuxuryCar constructor.");
	}

	@Override
	public void assembleCar() {
		super.assembleCar();
		System.out.println("Adding features of Luxury Car.");
	}
}
