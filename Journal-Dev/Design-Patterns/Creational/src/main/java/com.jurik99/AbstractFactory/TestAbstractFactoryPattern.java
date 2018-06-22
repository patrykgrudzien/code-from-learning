package com.jurik99.AbstractFactory;

public class TestAbstractFactoryPattern {

	public static void main(final String[] args) {
		final Computer pc = Factory.getComputer(new PCFactory("ram", "hdd", "cpu"));
		System.out.println(pc);
	}
}