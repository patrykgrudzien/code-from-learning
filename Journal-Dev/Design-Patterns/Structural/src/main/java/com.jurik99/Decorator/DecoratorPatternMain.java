package com.jurik99.Decorator;

public class DecoratorPatternMain {

	public static void main(final String[] args) {
		final Car sportsCar = new SportsCar(new BasicCar());
		System.out.println("\nASSEMBLING:");
		sportsCar.assembleCar();

		System.out.println("\n--------------------------------------------");

		final Car sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
		System.out.println("\nASSEMBLING:");
		sportsLuxuryCar.assembleCar();
	}
}
