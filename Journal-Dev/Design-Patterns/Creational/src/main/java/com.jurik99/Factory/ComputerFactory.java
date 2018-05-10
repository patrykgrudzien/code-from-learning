package com.jurik99.Factory;

public class ComputerFactory {

	public static Computer getComputer(final Type type, final String ram, final String hdd, final String cpu) {
		if (type == Type.PC)
			return new PC(ram, hdd, cpu);
		else if (type == Type.SERVER)
			return new Server(ram, hdd, cpu);

		return null;
	}

	private ComputerFactory() {}

	enum Type {
		PC, SERVER
	}
}
