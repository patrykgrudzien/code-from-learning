package com.jurik99;

import org.apache.log4j.Logger;

public class HelloExampleException
{
	private static final Logger logger = Logger.getLogger(HelloExampleException.class);

	public static void main(final String[] args)
	{
		try
		{
			HelloExampleException.divide();
		}
		catch (final Exception exception)
		{
			logger.error("Sorry, something wrong!", exception);
		}
	}

	private static void divide()
	{
		final int i = 10 / 0;
	}
}
