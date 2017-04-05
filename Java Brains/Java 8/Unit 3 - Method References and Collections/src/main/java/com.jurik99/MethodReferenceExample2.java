package com.jurik99;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MethodReferenceExample2
{
	@SuppressWarnings("Duplicates")
	public static void main(String[] args)
	{
		final List<Person> people = Arrays.asList(new Person("Patryk", "Nowak", 10),
		                                          new Person("Damian", "Grudzien", 20),
		                                          new Person("Celina", "Stawiarz", 30),
		                                          new Person("Viola", "Adamski", 40),
		                                          new Person("Amadeusz", "Chmmielewski", 50));

		// --- Print all elements in the list ---
		System.out.println("Printing all people:");
		performConditionally(people, person -> true, System.out::println); // p -> method(p)
		/*
		 * System.out - it's an INSTANCE
		 * println() - it's a method which is called on that instance (System.out)
		 *
		 * (System.out::println) knows about input argument because (Consumer<Person> consumer) takes input argument in
		 * consumer.accept(person);
		 */
	}

	private static void performConditionally(final List<Person> people, final Predicate<Person> predicate,
	                                         final Consumer<Person> consumer)
	{
		for (final Person person : people)
		{
			if (predicate.test(person))
			{
				consumer.accept(person);
			}
		}
	}
}
