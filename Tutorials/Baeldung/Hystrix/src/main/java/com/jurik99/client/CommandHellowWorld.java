package com.jurik99.client;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class CommandHellowWorld extends HystrixCommand<String> {

	private final String name;

	public CommandHellowWorld(final String name) {
		super(HystrixCommandGroupKey.Factory.asKey("Example-Group"));
		this.name = name;
	}

	@Override
	protected String run() throws Exception {
		return "Hello " + name;
	}
}
