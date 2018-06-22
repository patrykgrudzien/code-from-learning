package com.jurik99.AbstractFactory;

public class Server extends Computer {

	private String type;
	private String ram;
	private String hdd;
	private String cpu;

	public Server(final String ram, final String hdd, final String cpu) {
		this.type = Server.class.getSimpleName();
		this.ram = ram;
		this.hdd = hdd;
		this.cpu = cpu;
	}

	@Override
	public String getCPU() {
		return this.cpu;
	}

	@Override
	public String getHDD() {
		return this.hdd;
	}

	@Override
	public String getRAM() {
		return this.ram;
	}

	@Override
	public String getType() {
		return type;
	}
}
