package com.jurik99.Adapter;

public class MoveableAdapterImpl implements MoveableAdapter {

	private Moveable luxuryCars;

	MoveableAdapterImpl(final Moveable luxuryCars) {
		this.luxuryCars = luxuryCars;
	}

	@Override
	public double getSpeed() {
		return convertMPHtoKMH(luxuryCars.getSpeed());
	}

	private double convertMPHtoKMH(double mph) {
		return mph * 1.60934;
	}
}
