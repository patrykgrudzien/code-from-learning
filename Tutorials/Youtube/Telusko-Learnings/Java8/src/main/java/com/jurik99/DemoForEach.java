package com.jurik99;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class DemoForEach
{
	public static void main(final String[] args)
	{
		final List<Integer> values = Arrays.asList(4, 5, 6, 7, 8);

		values.forEach(number -> System.out.println(number));   // Lambda // Consumer
		System.out.println("--------------------------------------------");
		values.forEach(System.out::println);    // Method reference
		System.out.println("--------------------------------------------");

		final Consumer<Integer> consumer = new ConsumerImpl();
		values.forEach(consumer);
	}
}

class ConsumerImpl implements Consumer<Integer>
{
	@Override
	public void accept(final Integer integer)
	{
		System.out.println(integer);
	}
}

