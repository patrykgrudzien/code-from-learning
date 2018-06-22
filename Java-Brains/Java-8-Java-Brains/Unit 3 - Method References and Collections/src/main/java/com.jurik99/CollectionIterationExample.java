package com.jurik99;

import java.util.Arrays;
import java.util.List;

public class CollectionIterationExample
{
	public static void main(final String[] args)
	{
		final List<Person> people = Arrays.asList(new Person("Patryk", "Nowak", 10),
		                                          new Person("Damian", "Grudzien", 20),
		                                          new Person("Celina", "Stawiarz", 30),
		                                          new Person("Viola", "Adamski", 40),
		                                          new Person("Amadeusz", "Chmmielewski", 50));

		/**
		 * THESE ARE "EXTERNAL" ITERATORS (JAVA 7).
		 * Here we control iteration process (by specifing start, end points and interval)
		 */
		System.out.println("Using tradicional for loop:");
		for (int i = 0; i < people.size(); i++)
		{
			System.out.println(people.get(i));
		}

		System.out.println("\nFor each loop Java 7:");
		for (final Person p : people)
		{
			System.out.println(p);
		}

		/**
		 * JAVA 8 INTRODUCED NEW "INTERNAL" ITERATORS.
		 * We are giving the control to somebody else. How iteration happens is up to Runtime.
		 */
		System.out.println("\nJava 8 forEach():");
		people.forEach(System.out::println);
		// advantage of using smth like this is that it's very easy for processor to run in multiple threads

	}
}
