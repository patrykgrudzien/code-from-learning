package com.jurik99.Decorator;

/*
 * The basic implementation of the component interface. We can have "BasicCar" class as our component implementation.
 */
public class BasicCar implements Car
{
	@Override
	public void assembleCar()
	{
		System.out.print("Basic Car.");
	}
}
