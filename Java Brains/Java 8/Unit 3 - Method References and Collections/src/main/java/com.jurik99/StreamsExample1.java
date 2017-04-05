package com.jurik99;

import java.util.Arrays;
import java.util.List;

public class StreamsExample1
{
	public static void main(String[] args)
	{
		final List<Person> people = Arrays.asList(new Person("Patryk", "Nowak", 10),
		                                          new Person("Damian", "Grudzien", 20),
		                                          new Person("Celina", "Stawiarz", 30),
		                                          new Person("Viola", "Adamski", 40),
		                                          new Person("Amadeusz", "Chmmielewski", 50));

		// --- STREAM can be called as new view of collection, STREAM ALWAYS has a SOURCE ---
		people.stream().filter(person -> person.getLastName().startsWith("G")).forEach(
				person -> System.out.println(person.getFirstName()));

		// final Stream<Person> stream = people.stream();
		// final Stream<Person> stream = people.stream().filter(person -> person.getLastName().startsWith("G"));

		final long count = people.stream().filter(person -> person.getLastName().startsWith("G")).count();
		System.out.println("Count: " + count);

		// --- We can create parallel stream to work in multithread app ---
		final long parallelCount = people.parallelStream().filter(person -> person.getLastName().startsWith("G")).count();
	}
}
