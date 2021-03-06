package com.jurik99.messenger.helpers;

public enum LinkReferences
{
	SELF("self"), PROFILE("profile"), COMMENTS("comments");

	LinkReferences(final String reference)
	{
		this.reference = reference;
	}

	public String getReference()
	{
		return reference;
	}

	private String reference;
}
