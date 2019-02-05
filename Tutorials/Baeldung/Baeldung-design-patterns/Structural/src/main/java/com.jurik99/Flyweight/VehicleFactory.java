package com.jurik99.Flyweight;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

class VehicleFactory {

	// Stores the already created vehicles
	private static Map<Color, Vehicle> vehiclesCache = new HashMap<>();

	// Private constructor to prevent this class instantiation
	private VehicleFactory() {}

	/*
	 * Returns a vehicle of the same color passed as argument. If that vehicle
	 * was already created by this factory, that vehicle is returned, otherwise
	 * a new one is created and returned.
	 *
	 * Notice how the client code can only affect the extrinsic state of the object (the color of our vehicle)
	 * passing it as an argument to the createVehicle method.
	 */
	static Vehicle createVehicle(final Color color) {
		// Looks for the requested vehicle into the cache.
		// If the vehicle doesn't exist, a new one is created.
		final Vehicle newVehicle = vehiclesCache.computeIfAbsent(color, newColor -> {
			// Creates the new car
			final Engine newEngine = new Engine();
			return new Car(newEngine, newColor);
		});
		return newVehicle;
	}
}
