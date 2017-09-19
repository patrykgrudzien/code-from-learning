package com.jurik99;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SomeTestUsingExtendedRuleClass extends OwnRules
{
	@Test
	public void test1()
	{
		System.out.println("I'm test1");
		assertTrue(false);
	}

	@Test
	public void test2()
	{
		System.out.println("I'm test2");
		assertTrue(true);
	}
}
