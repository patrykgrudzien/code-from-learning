package com.jurik99.Decorator;

public class SportsCar extends CarDecorator
{
	public SportsCar(final Car car)
	{
		super(car);
	}

	@Override
	public void assembleCar()
	{
		super.assembleCar();
		System.out.print(" Adding features of Sports Car.");
	}
}
