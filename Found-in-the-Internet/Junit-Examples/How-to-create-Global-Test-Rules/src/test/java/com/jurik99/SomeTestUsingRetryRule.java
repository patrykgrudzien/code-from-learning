package com.jurik99;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;

public class SomeTestUsingRetryRule
{
	@Rule
	public Retry retry = new Retry(3);

	@Test
	public void test3()
	{
		System.out.println("I'm test1");
		assertTrue(false);
	}
}
