package com.jurik99;

public class MethodReferenceExample1
{
	public static void main(final String[] args)
	{
		final Thread t = new Thread(MethodReferenceExample1::printMessage); // () -> method()
		t.start();
	}

	private static void printMessage()
	{
		System.out.println("Hello");
	}
}
