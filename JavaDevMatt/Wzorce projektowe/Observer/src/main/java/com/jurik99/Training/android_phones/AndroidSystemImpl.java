package com.jurik99.Training.android_phones;

import java.util.ArrayList;
import java.util.List;

public class AndroidSystemImpl implements AndroidSystem
{
	private List<Phone> phones;

	public AndroidSystemImpl()
	{
		phones = new ArrayList<>();
	}

	@Override
	public void addSupport(final Phone phone)
	{
		phones.add(phone);
	}

	@Override
	public void removeSupport(final Phone phone)
	{
		phones.remove(phone);
	}

	@Override
	public void announceNewUpdate()
	{
		System.out.println("New update available!");
		notifyPhoneAboutUpdate();
	}

	@Override
	public void notifyPhoneAboutUpdate()
	{
		for (final Phone phone : phones)
		{
			phone.updateSystem();
		}
	}
}
