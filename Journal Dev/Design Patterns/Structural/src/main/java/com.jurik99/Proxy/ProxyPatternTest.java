package com.jurik99.Proxy;

public class ProxyPatternTest
{
	public static void main(final String[] args)
	{
		final CommandExecutor executor = new CommandExecutorProxy("patryk.grudzien", "password_wrong");

		try
		{
			executor.runCommand("ls -ltr");
			executor.runCommand(" rm -rf abc.pdf");
		}
		catch (final Exception exception)
		{
			System.out.println("Exception Message: " + exception.getMessage());
		}
	}
	/*
	 * Proxy design pattern common uses are to control access or to provide a wrapper implementation for better
	 * performance.
	 *
	 * Java RMI package uses proxy pattern.
	 */
}
