package com.jurik99.Training.android_phones;

public interface AndroidSystem
{
	void addSupport(final Phone phone);

	void removeSupport(final Phone phone);

	void notifyPhoneAboutUpdate();

	void announceNewUpdate();
}
