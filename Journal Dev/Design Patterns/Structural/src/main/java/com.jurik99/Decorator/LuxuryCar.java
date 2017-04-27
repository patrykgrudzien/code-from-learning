package com.jurik99.Decorator;

public class LuxuryCar extends CarDecorator
{
	public LuxuryCar(final Car car)
	{
		super(car);
	}

	@Override
	public void assembleCar()
	{
		super.assembleCar();
		System.out.print(" Adding features of Luxury Car.");
	}
}
