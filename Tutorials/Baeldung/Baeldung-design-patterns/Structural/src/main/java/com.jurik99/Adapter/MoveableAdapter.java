package com.jurik99.Adapter;

/**
 * An adapter pattern acts as a connector between two incompatible interfaces that otherwise cannot be connected directly.
 * An adapter wraps an existing class with a new interface so that it becomes compatible with client's interface.
 *
 * The main motive behind using this pattern is to convert an existing interface into another interface that the client expects.
 * It's usually implemented once the application is designed.
 */
public interface MoveableAdapter {

	// returns speed in KM/H
	double getSpeed();
}
