package com.jurik99.Proxy;

/*
 * Now we want to provide only admin users to have full access of above class. If the user is not admin then only
 * limited commands will be allowed. Here is our very simple proxy class implementation.
 */
public class CommandExecutorProxy implements CommandExecutor
{
	private boolean isAdmin;
	private CommandExecutor executor;

	public CommandExecutorProxy(final String user, final String password)
	{
		if (user.equals("patryk.grudzien") && password.equals("password"))
		{
			isAdmin = true;
		}
		executor = new CommandExecutorImpl();
	}

	@Override
	public void runCommand(final String cmd) throws Exception
	{
		if (isAdmin)
		{
			executor.runCommand(cmd);
		}
		else
		{
			if (cmd.trim().startsWith("rm"))
			{
				throw new Exception("rm command is not allowed for non-admin users.");
			}
			else
			{
				executor.runCommand(cmd);
			}
		}
	}
}
