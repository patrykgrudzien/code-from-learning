package com.jurik99.model;

public class User
{
	private String name;
	private String password;

	public User()
	{
	}

	public User(final String name)
	{
		this(name, "");
	}

	public User(final String name, final String password)
	{
		this.name = name;
		this.password = password;
	}

	public String getName()
	{
		return name;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(final String password)
	{
		this.password = password;
	}

	@Override
	public String toString()
	{
		return "User name: " + name;
	}
}
