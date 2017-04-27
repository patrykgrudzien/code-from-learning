package com.jurik99.Decorator;

public class DecoratorPatternMain
{
	public static void main(String[] args)
	{
		final Car sportsCar = new SportsCar(new BasicCar());
		sportsCar.assembleCar();

		System.out.println("\n--------------------------------------------");

		final Car sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
		sportsLuxuryCar.assembleCar();
	}
}
