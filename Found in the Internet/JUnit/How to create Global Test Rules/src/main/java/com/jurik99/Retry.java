package com.jurik99;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class Retry implements TestRule
{
	private int retryCount;

	public Retry(final int retryCount)
	{
		this.retryCount = retryCount;
	}

	@Override
	public Statement apply(final Statement base, final Description description)
	{
		// --- STATEMENT ---
		// Represents one or more actions to be taken at runtime in the course of running a JUnit test suite.
		return new Statement() {
			@Override
			public void evaluate() throws Throwable
			{
				Throwable throwable = null;
				for (int i = 0; i < retryCount; i++)
				{
					try
					{
						base.evaluate();    // RUN TEST AGAIN
						return;
					}
					catch (final Throwable t)
					{
						throwable = t;
						System.out.println("Run " + (i + 1) + " failed!");
					}
				}
				System.out.println("Giving up after " + retryCount + " failures...");
				throw throwable;
			}
		};
	}
}
