package com.jurik99.list_of_strings_to_uppercase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestJava8
{
	/**
	 * In Java 8, stream().map() lets you convert an object to something else.
	 */
	public static void main(final String[] args)
	{
		final List<String> alpha = Arrays.asList("a", "b", "c", "d");

		// --- BEFORE JAVA 8 ---
		final List<String> alphaUpper = new ArrayList<>();
		for (final String s : alpha)
		{
			alphaUpper.add(s.toUpperCase());
		}
		System.out.println(alpha);
		System.out.println(alphaUpper);

		System.out.println("--------------------------------------------");

		// --- JAVA 8 ---
		final List<String> collect = alpha.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(collect);

		// --- EXTRA, streams APPLY TO ANY DATA TYPE ---
		final List<Integer> num = Arrays.asList(1, 2, 3, 4, 5);
		final List<Integer> collect1 = num.stream().map(number -> number * 2).collect(Collectors.toList());
		System.out.println(collect1);
	}
}
