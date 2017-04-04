package com.jurik99;

public class MethodReferenceExample1
{
	public static void main(String[] args)
	{
		final Thread t = new Thread(MethodReferenceExample1::printMessage);
		t.start();
	}

	private static void printMessage()
	{
		System.out.println("Hello");
	}
}
