package com.jurik99;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class Unit1ExerciseSolutionJava8Test
{
	private static List<Person> people;

	@BeforeClass
	public static void setUp()
	{
		people = Unit1ExerciseSolutionJava8.prepareListOfPeople();
	}

	@Test
	public void testListOfPeopleNotNull()
	{
		assertNotNull(people);
	}

	@Test
	public void testListSizeGreaterThanZero()
	{
		assertThat(people.size(), greaterThan(0));
	}
}
