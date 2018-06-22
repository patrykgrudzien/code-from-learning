package com.jurik99.service;

public class RemoteServiceSimulator {

	private long wait;

	public RemoteServiceSimulator(final long wait) {
		this.wait = wait;
	}

	public String testService() throws InterruptedException {
		Thread.sleep(wait);
		return "Success";
	}
}
