package com.jurik99.Decorator;

/*
 * The basic implementation of the component interface. We can have "BasicCar" class as our component implementation.
 */
public class BasicCar implements Car {

	public BasicCar() {
		System.out.println("BasicCar constructor.");
	}

	@Override
	public void assembleCar() {
		System.out.println("Assemble Basic Car.");
	}
}
