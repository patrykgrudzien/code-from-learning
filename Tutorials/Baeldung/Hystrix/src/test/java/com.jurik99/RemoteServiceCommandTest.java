package com.jurik99;

import org.junit.Test;

import com.jurik99.client.RemoteServiceCommand;
import com.jurik99.service.RemoteServiceSimulator;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolProperties;
import com.netflix.hystrix.exception.HystrixRuntimeException;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class RemoteServiceCommandTest {

	@Test
	public void givenServiceTimeoutOf100AndDefaultSettings_whenRemoteServiceExecuted_thenReturnSuccess() {

		final HystrixCommand.Setter config = HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("Remote-Service-Group"));

		assertThat(new RemoteServiceCommand(config, new RemoteServiceSimulator(100)).execute(), equalTo("Success"));
	}

	@Test
	public void givenSvcTimeoutOf15000AndExecTimeoutOf5000_whenRemoteSvcExecuted_thenExpectHre() throws InterruptedException {

		final HystrixCommand.Setter group = HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("Remote-Service-Group-2"))
		                                                         .andCommandKey(HystrixCommandKey.Factory.asKey("TEST-2"));

		assertThat(new RemoteServiceCommand(group, new RemoteServiceSimulator(2000)).execute(), equalTo("getFallback() called"));
	}

	@Test
	public void givenCircuitBreakerSetup_whenRemoteServiceCommandExecuted_thenReturnSuccess() throws InterruptedException {

		final HystrixCommand.Setter config = HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("TEST-3"));

		HystrixCommandProperties.Setter properties = HystrixCommandProperties.Setter();
		properties.withExecutionTimeoutInMilliseconds(1000);
		properties.withCircuitBreakerSleepWindowInMilliseconds(4000); // hystrix does not call service for 4sec
		properties.withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD);
		properties.withCircuitBreakerEnabled(true);
		properties.withCircuitBreakerRequestVolumeThreshold(1);

		config.andCommandPropertiesDefaults(properties);
		config.andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter()
		                                                                  .withMaxQueueSize(1)
		                                                                  .withCoreSize(1)
		                                                                  .withQueueSizeRejectionThreshold(1));

		assertThat(this.invokeRemoteService(config, 10_000), equalTo("getFallback() called"));
		assertThat(this.invokeRemoteService(config, 10_000), equalTo("getFallback() called"));
		assertThat(this.invokeRemoteService(config, 10_000), equalTo("getFallback() called"));

		Thread.sleep(5000);

		assertThat(new RemoteServiceCommand(config, new RemoteServiceSimulator(500)).execute(), equalTo("Success"));
		assertThat(new RemoteServiceCommand(config, new RemoteServiceSimulator(500)).execute(), equalTo("Success"));
		assertThat(new RemoteServiceCommand(config, new RemoteServiceSimulator(500)).execute(), equalTo("Success"));
	}

	private String invokeRemoteService(final HystrixCommand.Setter config, final int timeout) {
		String response = null;
		try {
			response = new RemoteServiceCommand(config, new RemoteServiceSimulator(timeout)).execute();
		} catch (final HystrixRuntimeException exception) {
			System.out.println("exception = " + exception);
		}
		return response;
	}
}