package com.jurik99.AbstractFactory;

public class ServerFactory implements AbstractFactory {

	private String ram;
	private String hdd;
	private String cpu;

	public ServerFactory(final String ram, final String hdd, final String cpu) {
		this.ram = ram;
		this.hdd = hdd;
		this.cpu = cpu;
	}

	@Override
	public Computer createComputer() {
		return new Server(ram, hdd, cpu);
	}
}
