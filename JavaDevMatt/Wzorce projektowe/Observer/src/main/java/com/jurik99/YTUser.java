package com.jurik99;

public class YTUser implements Observer
{
	private String name;
	private int videosToWatch;

	public YTUser(final String name)
	{
		this.name = name;
		this.videosToWatch = 0;
	}

	public String getName()
	{
		return name;
	}

	public int getVideosToWatch()
	{
		return videosToWatch;
	}

	@Override
	public void update()
	{
		videosToWatch++;
		System.out.println("Hey " + name + "! There is a new viedo! You have " + videosToWatch + " videos to watch.");
	}
}
