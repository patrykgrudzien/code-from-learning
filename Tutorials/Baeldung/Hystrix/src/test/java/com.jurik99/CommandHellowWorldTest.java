package com.jurik99;

import org.junit.Test;

import com.jurik99.client.CommandHellowWorld;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class CommandHellowWorldTest {

	@Test
	public void givenInputBobAndDefaultSettings_whenCommandExecuted_thenReturnHelloBob() {
		assertThat(new CommandHellowWorld("Bob").execute(), equalTo("Hello Bob"));
	}
}