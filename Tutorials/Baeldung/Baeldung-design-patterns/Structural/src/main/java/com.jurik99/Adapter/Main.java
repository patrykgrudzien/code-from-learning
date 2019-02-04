package com.jurik99.Adapter;

/**
 * The adapter pattern describes how to convert an object into another object which a clients expects.
 * This pattern mainly adapts one object to another one.
 * Adapters allow objects to work together that couldn’t otherwise because of incompatible interfaces.
 *
 * Adapter allows to reuse existing coding without changing it, as the adapter ensures the conversion between the different interfaces.
 *
 * In comparison to a decorator pattern, the adapter pattern only converts objects, while the decorator pattern adds new functionality to an existing object.
 * Therefore, the decorator does not change the existing interface.
 */
public class Main {

	public static void main(final String[] args) {

		final Moveable bugattiVeyron = new BugattiVeyron();
		final MoveableAdapter bugattiAdapter = new MoveableAdapterImpl(bugattiVeyron);

		System.out.println("bugattiVeyron.getSpeed() = " + bugattiVeyron.getSpeed());
		System.out.println("bugattiAdapter.getSpeed() = " + bugattiAdapter.getSpeed());
	}
}
