package com.jurik99.messenger.model;

import java.util.Date;

public class Comment
{
	private long id;
	private String message;
	private Date created;
	private String author;

	public Comment()
	{
	}

	public Comment(final long id, final String message, final String author)
	{
		this.id = id;
		this.message = message;
		this.author = author;
		this.created = new Date();
	}

	public long getId()
	{
		return id;
	}

	public void setId(final long id)
	{
		this.id = id;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(final String message)
	{
		this.message = message;
	}

	public Date getCreated()
	{
		return created;
	}

	public void setCreated(final Date created)
	{
		this.created = created;
	}

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(final String author)
	{
		this.author = author;
	}
}
