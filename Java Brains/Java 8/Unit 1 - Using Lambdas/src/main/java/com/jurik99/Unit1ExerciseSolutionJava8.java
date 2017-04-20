package com.jurik99;

import java.util.Arrays;
import java.util.List;

import static com.jurik99.Unit1ExerciseSolutionJava7.printConditionally;

public class Unit1ExerciseSolutionJava8
{
	public static void main(String[] args)
	{
		final List<Person> people = prepareListOfPeople();

		// --- Step 1. Sort list by last name ---
		people.sort((person1, person2) -> person2.getLastName().compareTo(person1.getLastName()));

		// --- Step 2. Create method that prints all elements in the list ---
		System.out.println("Printing all people:");
		printConditionally(people, person -> true);

		// --- Step 3. Create a method that prints all people that have last name beginning with C ---
		System.out.println("\nPrinting all people with last name beginning with S:");
		printConditionally(people, person -> person.getLastName().startsWith("S"));

		// --- Step 4. Create a method that prints all people that have first name beginning with C ---
		System.out.println("\nPrinting all people with first name beginning with V:");
		printConditionally(people, person -> person.getFirstName().startsWith("V"));
	}

	public static List<Person> prepareListOfPeople()
	{
		return Arrays.asList(new Person("Patryk", "Nowak", 10),
		                     new Person("Damian", "Grudzien", 20),
		                     new Person("Celina", "Stawiarz", 30),
		                     new Person("Viola", "Adamski", 40),
		                     new Person("Andrzej", "Chmmielewski", 50));
	}
}
