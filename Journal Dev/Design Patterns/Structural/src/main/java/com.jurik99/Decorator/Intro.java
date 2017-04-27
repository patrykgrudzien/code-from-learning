package com.jurik99.Decorator;

public class Intro
{
	/*
	 * Decorator design pattern is used to modify the functionality of an object at runtime.
	 * At the same time other instances of the same class will not be affected by this, so individual object gets the
	 * modified behavior.
	 * Decorator design pattern is one of the structural design pattern (such as Adapter, Bridge, Composite) and uses
	 * abstract classes or interface with composition to implement.
	 *
	 * --- DECORATOR DESIGN PATTERN ---
	 * We use "inheritance" or "composition" to extend the behavior of an object but this is done at compile time and
	 * its applicable to all the instances of the class. We can't add any new functionality or remove any existing
	 * behavior at runtime - this is when DECORATOR pattern comes into picture.
	 *
	 * Suppose we want to implement different kind of cars - we can create interface Car to define the assemble
	 * method and then we can have a Basic car, further more we can extend it to Sports Car and Luxury Car.
	 *
	 * But if we want to get a car at runtime that has both features of sports car and luxury car, then the
	 * implementation gets complex and if further more we want to specify which features should be added first, it
	 * gets even more complex. Now imagine if we have ten different kind of cars, the implementation logic using
	 * inheritance and composition will be impossible to manage. To solve this kind of programming situation, we
	 * apply decorator pattern.
	 *
	 * Step-by-step:
	 * 1) Component interface - Car
	 * 2) Component implementation - BasicCar
	 * 3) Decorator - CarDecorator
	 * 4) Concrete Decorators - SportsCar, LuxuryCar
	 * 5) MainClass
	 */
}
