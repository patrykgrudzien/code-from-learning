package com.jurik99.Factory;

public class TestFactory {

	public static void main(final String[] args) {
		final Computer pc = ComputerFactory.getComputer(ComputerFactory.Type.PC, "2GB", "500GB", "2,4GHz");
		final Computer server = ComputerFactory.getComputer(ComputerFactory.Type.SERVER, "16GB", "1TB", "2,9GHz");

		System.out.println(pc);
		System.out.println(server);
	}
}
