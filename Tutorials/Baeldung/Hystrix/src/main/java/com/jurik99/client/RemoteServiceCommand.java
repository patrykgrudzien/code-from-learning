package com.jurik99.client;

import com.jurik99.service.RemoteServiceSimulator;
import com.netflix.hystrix.HystrixCommand;

public class RemoteServiceCommand extends HystrixCommand<String> {

	private RemoteServiceSimulator remoteService;

	public RemoteServiceCommand(final Setter config, final RemoteServiceSimulator remoteService) {
		super(config);
		this.remoteService = remoteService;
	}

	@Override
	protected String run() throws Exception {
		return remoteService.testService();
	}

	@Override
	protected String getFallback() {
		return "getFallback() called";
	}
}
