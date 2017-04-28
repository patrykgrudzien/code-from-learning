package com.jurik99;

public interface Subject
{
	void register(final Observer observer);

	void unregister(final Observer observer);

	void notifyObservers();
}
