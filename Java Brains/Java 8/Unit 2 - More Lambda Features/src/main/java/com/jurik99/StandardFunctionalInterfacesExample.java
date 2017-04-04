package com.jurik99;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class StandardFunctionalInterfacesExample
{
	@SuppressWarnings("Duplicates")
	public static void main(String[] args)
	{
		final List<Person> people = Arrays.asList(new Person("Patryk", "Nowak", 10),
		                                          new Person("Damian", "Grudzien", 20),
		                                          new Person("Celina", "Stawiarz", 30),
		                                          new Person("Viola", "Adamski", 40),
		                                          new Person("Andrzej", "Chmmielewski", 50));

		// --- Step 1. Sort list by last name ---
		people.sort((person1, person2) -> person2.getLastName().compareTo(person1.getLastName()));

		// --- Step 2. Create method that prints all elements in the list ---
		System.out.println("Printing all people:");
		performConditionally(people, person -> true, person -> System.out.println(person));

		// --- Step 3. Create a method that prints all people that have last name beginning with C ---
		System.out.println("\nPrinting all people with last name beginning with S:");
		performConditionally(people, person -> person.getLastName().startsWith("S"),
		                     person -> System.out.println(person.getLastName()));

		// --- Step 4. Create a method that prints all people that have first name beginning with C ---
		System.out.println("\nPrinting all people with first name beginning with V:");
		performConditionally(people, person -> person.getFirstName().startsWith("V"),
		                     person -> System.out.println(person.getFirstName()));
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