package com.jurik99.model;

public class Topic
{
	private String id;
	private String name;
	private String description;

	public Topic()
	{
	}

	public Topic(final String id, final String name, final String description)
	{
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public String getId()
	{
		return id;
	}

	public void setId(final String id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(final String description)
	{
		this.description = description;
	}
}
