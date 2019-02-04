package com.jurik99.Adapter;

public class Main {

	public static void main(final String[] args) {

		final Moveable bugattiVeyron = new BugattiVeyron();
		final MoveableAdapter bugattiAdapter = new MoveableAdapterImpl(bugattiVeyron);

		System.out.println("bugattiVeyron.getSpeed() = " + bugattiVeyron.getSpeed());
		System.out.println("bugattiAdapter.getSpeed() = " + bugattiAdapter.getSpeed());
	}
}
