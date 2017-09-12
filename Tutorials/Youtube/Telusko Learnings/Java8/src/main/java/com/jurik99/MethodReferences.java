package com.jurik99;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MethodReferences
{
	public static void main(final String[] args)
	{
		/**
		 * Method references in Java 8 allows us to convert call to a method or a constructor into instance of
		 * functional interface. For example lambda expression like "x -> x.foo()" using method reference results in
		 * expression "FooClass:foo" that is more clear and readable.
		 */

		/*
		 * We will start demonstrating how to use method references to call instance methods:
		 */

		// --- Both functions do the same thing: ---
		final Function<Person, String> getNameLambda = person -> person.getName();
		final Function<Person, String> getNameMethRef = Person::getName;

		// --- How to use it with streams: ---
		Stream.of(new Person("Mike"), new Person("Maya"), new Person("Carl")).map(person -> person.getName())
		      .collect(Collectors.toList());

		Stream.of(new Person("Mike"), new Person("Maya"), new Person("Carl")).map(Person::getName)
		      .collect(Collectors.toList());

		/*
		 * Another kind of lampda expressions that can be changed to method references has form
		 * "arg -> someObj.method(arg)", here the instance on which method is called is constant but the argument
		 * changes. Let's continue with "Person":
		 */
		final List<Person> linuxUsers = new ArrayList<>();

		final Consumer<Person> addUserLambda = user -> linuxUsers.add(user);
		final Consumer<Person> addUserMethRef = linuxUsers::add;

		Stream.of(new Person("Mike"), new Person("Maya"), new Person("Carl"))
		      .forEach(person -> linuxUsers.add(person));

		Stream.of(new Person("Mike"), new Person("Maya"), new Person("Carl")).forEach(linuxUsers::add);

		/*
		 * This approach also works with methods that have more than one parameter:
		 */
		final Person anonymous = new Person();

		final BiConsumer<String, String> setNamesLambda = (firstName, lastName) -> anonymous.setName(firstName, lastName);
		final BiConsumer<String, String> setNamesMethRef = anonymous::setName;

		/*
		 * Now let's move to constructor references. Every lambda expression in form: "() -> new FooClass()" can be
		 * rewritten to use constructor references as "FooClass::new", for example:
		 */
		final Supplier<ArrayList<Person>> createListLambda = () -> new ArrayList<>();
		final Supplier<ArrayList<Person>> createListMethRef = ArrayList::new;

		// --- This also works when constructor has parameters: ---
		final Function<String, Person> createPersonWithNameLambda = name -> new Person(name);
		final Function<String, Person> createPersonWithNameMethRef = Person::new;

		// --- We may even use constructor references to create arrays: ---
		final IntFunction<String[]> createArrayLambda = size -> new String[size];
		final IntFunction<String[]> createArrayMethRef = String[]::new;

		// --- Last example -> how to use method references to refer to super class methods: ---
	}
}

class Person
{
	private String name;

	Person() {}

	Person(final String name)
	{
		this.name = name;
	}

	String getName()
	{
		return name;
	}

	void setName(final String firstName, final String lastName)
	{
		name = firstName + " " + lastName;
	}
}

abstract class SuperClass
{
	void method()
	{
		System.out.println("superClass method()");
	}
}

class SubClass extends SuperClass
{
	@Override
	void method()
	{
		final Runnable superMethodLambda = () -> super.method();
		final Runnable superMethodReference = SubClass.super::method;
	}
}

