package com.jurik99;

public class Book
{
	private double price;
	private String title;
	private String cover;
	private boolean available;

	public Book(final double price, final String title, final String cover, final boolean available)
	{
		this.price = price;
		this.title = title;
		this.cover = cover;
		this.available = available;
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice(final double price)
	{
		this.price = price;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(final String title)
	{
		this.title = title;
	}

	public String getCover()
	{
		return cover;
	}

	public void setCover(final String cover)
	{
		this.cover = cover;
	}

	public boolean isAvailable()
	{
		return available;
	}

	public void setAvailable(final boolean available)
	{
		this.available = available;
	}
}
