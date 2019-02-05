package com.jurik99.Flyweight;

import org.apache.commons.lang3.StringUtils;

import java.awt.Color;

/**
 * This pattern is used to reduce the memory footprint. It can also improve performance in applications
 * where object instantiation is expensive.
 *
 * Simply put, the flyweight pattern is based on a factory which recycles created objects by storing them
 * after creation. Each time an object is requested, the factory looks up the object in order to check if
 * it's already been created. If it has, the existing object is returned - otherwise, a new one is created, stored and then returned.
 *
 * The flyweight object's state is made up of an invariant component shared with other similar objects (intrinsic) and a
 * variant component which can be manipulated by the client code (extrinsic).
 *
 * It's very important that the flyweight objects are immutable: any operation on the state must beb performed by the factory!
 *
 * The main elements of the pattern are:
 *
 * 1) an interface which defines the operations that the client code can perform on the flyweight object
 * 2) one or more concrete implementations of our interface
 * 3) a factory to handle objects instantiation and caching
 */
public class Main {

	public static void main(final String[] args) {

		final Vehicle blueVehicle1 = VehicleFactory.createVehicle(Color.BLUE);
		final Vehicle blueVehicle2 = VehicleFactory.createVehicle(Color.BLUE);

		System.out.println("blueVehicle1.getColor().toString() = " + blueVehicle1.getColor().toString());
		blueVehicle1.start();

		System.out.println(StringUtils.repeat("-", 50));

		System.out.println("blueVehicle2.getColor().toString() = " + blueVehicle2.getColor().toString());
		blueVehicle2.start();
	}
}
