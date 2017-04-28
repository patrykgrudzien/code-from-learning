package com.jurik99.Implementation;

import java.util.ArrayList;
import java.util.List;

public class YTChannel implements Subject
{
	private List<Observer> observerList;

	public YTChannel()
	{
		observerList = new ArrayList<>();
	}

	@Override
	public void register(final Observer observer)
	{
		observerList.add(observer);
	}

	@Override
	public void unregister(final Observer observer)
	{
		observerList.remove(observer);
	}

	@Override
	public void notifyObservers()
	{
		for (final Observer observer : observerList)
		{
			observer.update();
		}
	}

	public void publishNewVideo()
	{
		System.out.println("YTChannel: Publishing new video...");
		notifyObservers();
	}

	public List<Observer> getObserverList()
	{
		return observerList;
	}
}
