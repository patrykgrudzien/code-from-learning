package com.jurik99.Training.android_phones;

public class SonyXperia implements Phone
{
	private String model;
	private int systemVersion;

	public SonyXperia(final String model)
	{
		this.model = model;
		systemVersion = 5;
		System.out.println(model + " - my system version is: " + systemVersion);
	}

	public String getModel()
	{
		return model;
	}

	public int getSystemVersion()
	{
		return systemVersion;
	}

	@Override
	public void updateSystem()
	{
		systemVersion += 1;
		System.out.println("Hey Sony Xperia " + model + "! You can update your phone to new version: " + systemVersion);
	}
}
