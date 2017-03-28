package com.jurik99.messenger.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@XmlRootElement
public class Message
{
	private long id;
	private String message;
	private Date created;
	private String author;

	private Map<Long, Comment> comments = new HashMap<>();

	public Message()
	{
	}

	public Message(final long id, final String message, final String author)
	{
		this.id = id;
		this.message = message;
		this.author = author;
		this.created = new Date();
	}

	/*
	* We don't want to show COMMENT data when message instance is pulled up from the API.
	*/
	@XmlTransient
	public Map<Long, Comment> getComments()
	{
		return comments;
	}

	public void setComments(final Map<Long, Comment> comments)
	{
		this.comments = comments;
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