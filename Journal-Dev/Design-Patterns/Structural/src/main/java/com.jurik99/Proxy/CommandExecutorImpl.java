package com.jurik99.Proxy;

public class CommandExecutorImpl implements CommandExecutor
{
	@Override
	public void runCommand(final String cmd)
			throws Exception
	{
		// --- some heavy implementation ---
		Runtime.getRuntime().exec(cmd);
		System.out.println("'" + cmd + "' command executed.");
	}
}
