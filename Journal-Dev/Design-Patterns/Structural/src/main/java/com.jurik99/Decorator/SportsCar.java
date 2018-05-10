package com.jurik99.Decorator;

public class SportsCar extends CarDecorator {

	public SportsCar(final Car car) {
		super(car);
		System.out.println("SportsCar constructor.");
	}

	@Override
	public void assembleCar() {
		super.assembleCar();
		System.out.println("Adding features of Sports Car.");
	}
}
