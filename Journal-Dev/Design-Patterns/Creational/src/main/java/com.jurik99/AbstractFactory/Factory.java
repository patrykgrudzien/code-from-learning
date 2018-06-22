package com.jurik99.AbstractFactory;

public class Factory {

	public static Computer getComputer(final AbstractFactory abstractFactory) {
		return abstractFactory.createComputer();
	}
}
