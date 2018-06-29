package com.jurik99.Training.android_phones;

public class Main
{
	public static void main(final String[] args)
	{
		final AndroidSystem system = new AndroidSystemImpl();
		final Phone sonyXperiaZ3 = new SonyXperia("Z3");

		system.addSupport(sonyXperiaZ3);
		system.announceNewUpdate();

		System.out.println("--------------------------------------------");

		final Phone sonyXperiaZ5 = new SonyXperia("Z5");
		system.addSupport(sonyXperiaZ5);
		system.announceNewUpdate();
		system.announceNewUpdate();
	}
}
