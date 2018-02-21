package com.jurik99.rest;

public class MyDate
{
	private int date;
	private int month;
	private int year;

	public int getDate()
	{
		return date;
	}

	public void setDate(final int date)
	{
		this.date = date;
	}

	public int getMonth()
	{
		return month;
	}

	public void setMonth(final int month)
	{
		this.month = month;
	}

	public int getYear()
	{
		return year;
	}

	public void setYear(final int year)
	{
		this.year = year;
	}

	@Override
	public String toString()
	{
		return "MyDate{" + "date=" + date + ", month=" + month + ", year=" + year + '}';
	}
}
