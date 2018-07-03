package com.jurik99;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest
{
	public static void main(final String[] args)
	{
		final Predicate<Integer> positive = integer -> integer > 0;
		final List<Integer> integerList = Arrays.asList(1, 10, 200, 101, -10, 0);

		final List<Integer> filteredListLambdaInline = filterList(integerList, integer -> integer > 0);
		final List<Integer> filteredListWithVariable = filterList(integerList, positive);

		filteredListLambdaInline.forEach(System.out::println);
	}

	private static List<Integer> filterList(final List<Integer> listOfIntegers, final Predicate<Integer> predicate)
	{
		final List<Integer> filteredList = new ArrayList<>();
		for (final Integer integer : listOfIntegers)
		{
			if (predicate.test(integer))
			{
				filteredList.add(integer);
			}
		}
		return filteredList;
	}
}

