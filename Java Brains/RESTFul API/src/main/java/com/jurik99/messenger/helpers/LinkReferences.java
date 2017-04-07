package com.jurik99.messenger.helpers;

public enum LinkReferences
{
	SELF("self");

	LinkReferences(final String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	private String name;
}
