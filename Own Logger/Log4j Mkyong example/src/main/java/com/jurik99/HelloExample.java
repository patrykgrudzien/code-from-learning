package com.jurik99;

import org.apache.log4j.Logger;

public class HelloExample
{
	private static final Logger logger = Logger.getLogger(HelloExample.class);

	public static void main(String[] args)
	{
		final HelloExample obj = new HelloExample();
		obj.runMe("JuRik99");
	}

	private void runMe(final String parameter)
	{
		if (logger.isDebugEnabled())
		{
			logger.debug("This is debug: " + parameter);
		}
		if (logger.isInfoEnabled())
		{
			logger.info("This is info: " + parameter);
		}
		logger.warn("This is warn : " + parameter);
		logger.error("This is error : " + parameter);
		logger.fatal("This is fatal : " + parameter);
	}
}
