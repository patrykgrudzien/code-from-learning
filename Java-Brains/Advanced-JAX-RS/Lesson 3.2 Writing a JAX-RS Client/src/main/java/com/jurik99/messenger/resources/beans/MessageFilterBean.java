package com.jurik99.messenger.resources.beans;

import javax.ws.rs.QueryParam;

public class MessageFilterBean
{
	private @QueryParam("year") int year;
	private @QueryParam("start") int start;
	private @QueryParam("size") int size;

	public void setYear(final int year)
	{
		this.year = year;
	}

	public void setStart(final int start)
	{
		this.start = start;
	}

	public void setSize(final int size)
	{
		this.size = size;
	}

	public int getYear()
	{
		return year;
	}

	public int getStart()
	{
		return start;
	}

	public int getSize()
	{
		return size;
	}
}
