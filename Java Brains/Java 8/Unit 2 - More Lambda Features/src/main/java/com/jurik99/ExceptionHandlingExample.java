package com.jurik99;

import java.util.function.BiConsumer;

public class ExceptionHandlingExample
{
	public static void main(String[] args)
	{
		final int[] someNumbers = {1, 2, 3, 4};
		final int key = 0;

		process(someNumbers, key, wrapperLambda((v, k) -> System.out.println(v / k)));
	}

	private static void process(final int[] someNumbers, final int key, final BiConsumer<Integer, Integer> consumer)
	{
		for (final int i : someNumbers)
		{
			consumer.accept(i, key);
		}
	}

	private static BiConsumer<Integer, Integer> wrapperLambda(final BiConsumer<Integer, Integer> consumer)
	{
		return (v, k) ->
		{
			try
			{
				consumer.accept(v, k);
			}
			catch (final ArithmeticException exception)
			{
				System.out.println("Exception caught in wrapper lambda!");
			}
		};
	}
}
