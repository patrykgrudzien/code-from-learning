package com.jurik99.Decorator;

/*
 * Decorator class implements the component interface and it has a HAS-A relationship with the component interface.
 * The component variable should be accessible to the child decorator classes, so we will make this variable protected.
 */
public class CarDecorator implements Car {

	private Car car;

	public CarDecorator(final Car car) {
		this.car = car;
		System.out.println("Decorator constructor. Car: " + car);
	}

	@Override
	public void assembleCar() {
		this.car.assembleCar();
		System.out.println("Assemble Car Decorator. Car: " + car);
	}
}
