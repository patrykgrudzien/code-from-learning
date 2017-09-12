package com.jurik99;

import java.util.function.Consumer;

public class ConsumerTest
{
	public static void main(final String[] args)
	{
		// --- Consumer accepts a single argument by calling its "accept(args)" method and does not return any value ---
		final Consumer<String> consumer = ConsumerTest::printNames;
		consumer.accept("Tom");
		consumer.accept("John");
		consumer.accept("Jessica");
	}

	private static void printNames(final String name)
	{
		System.out.println(name);
	}
}
