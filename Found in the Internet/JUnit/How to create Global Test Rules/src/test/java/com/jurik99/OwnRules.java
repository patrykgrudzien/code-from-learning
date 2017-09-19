package com.jurik99;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class OwnRules
{
	/*
	 * This is gonna be reused in multiple places around couple of JUnit tests (like AOP concept).
	 * We don't want to write it over and over again (we want to avoid redundant code).
	 */

	@BeforeClass
	public static void beforeClass()
	{
		System.out.println("I'm beforeClass method.");
	}

	@Before
	public void before()
	{
		System.out.println("I'm before method.");
	}

	@After
	public void after()
	{
		System.out.println("I'm after method.");
	}

	@AfterClass
	public static void afterClass()
	{
		System.out.println("I'm afterClass method.");
	}

	/*
	 * We want to have logic that is being executed when my tests will fail or succeed.
	 */
	@Rule
	public TestRule listen = new TestWatcher() {
		@Override
		protected void failed(final Throwable throwable, final Description description)
		{
			System.out.println(description.getMethodName() + " FAILED.");
		}

		@Override
		protected void succeeded(final Description description)
		{
			System.out.println(description.getMethodName() + " PASSED.");
		}
	};
}
