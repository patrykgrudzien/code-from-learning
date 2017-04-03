package com.jurik99;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Unit1ExerciseSolutionJava7
{
	public static void main(String[] args)
	{
		final List<Person> people = Arrays.asList(
				new Person("Patryk", "Nowak", 10),
				new Person("Damian", "Grudzien", 20),
				new Person("Celina", "Stawiarz", 30),
				new Person("Viola", "Adamski", 40),
				new Person("Andrzej", "Chmmielewski", 50));

		// --- Step 1. Sort list by last name ---
		people.sort(new Comparator<Person>()
		{
			@Override
			public int compare(final Person person1, final Person person2)
			{
				return person1.getLastName().compareTo(person2.getLastName());
			}
		});

		// --- Step 2. Create method that prints all elements in the list ---
		System.out.println("Printing all people:");
		printAll(people);

		// --- Step 3. Create a method that prints all people that have last name beginning with C ---
		System.out.println("\nPrinting all people with last name beginning with C:");
		printConditionally(people, new Condition()
		{
			@Override
			public boolean test(final Person person)
			{
				return person.getLastName().startsWith("C");
			}
		});

		// --- Step 4. Create a method that prints all people that have first name beginning with C ---
		System.out.println("\nPrinting all people with first name beginning with C:");
		printConditionally(people, new Condition()
		{
			@Override
			public boolean test(final Person person)
			{
				return person.getFirstName().startsWith("C");
			}
		});
	}

	static void printAll(final List<Person> people)
	{
		for (final Person person : people)
		{
			System.out.println(person);
		}
	}

	static void printConditionally(final List<Person> people, final Condition condition)
	{
		for (final Person person : people)
		{
			if (condition.test(person))
			{
				System.out.println(person);
			}
		}
	}
}

interface Condition
{
	boolean test(Person person);
}
