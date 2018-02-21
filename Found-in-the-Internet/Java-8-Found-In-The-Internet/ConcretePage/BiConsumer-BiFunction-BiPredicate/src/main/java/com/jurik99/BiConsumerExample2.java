package com.jurik99;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class BiConsumerExample2 {

	// --- TESTING IN "Person" CLASS BELOW ---
}

@Getter
@Setter
@NoArgsConstructor
class Person {

	private String name;
	private String lastName;
	private String email;
	private String address;

	private Person(final String name, final String lastName) {
		this.name = name;
		this.lastName = lastName;
	}

	// --- Use the Person's method references and assign them to functions ---

	// --- GETTERS ---
	private static Function<Person, String> getNameFunction = Person::getName;
	private static Function<Person, String> getLastNameFunction = Person::getLastName;
	private static Function<Person, String> getEmailFunction = Person::getEmail;
	private static Function<Person, String> getAddressFunction = Person::getAddress;

	// --- SETTERS ---
	private static BiConsumer<Person, String> setNameFunction = Person::setName;
	private static BiConsumer<Person, String> setLastNameFunction = Person::setLastName;
	private static BiConsumer<Person, String> setEmailFunction = Person::setEmail;
	private static BiConsumer<Person, String> setAddressFunction = Person::setAddress;

	// --- DEFAULT CONSTRUCTOR ---
	private static Supplier<Person> defaultConstructor = Person::new;

	// --- TWO ARGS CONSTRUCTOR ---
	private static BiFunction<String, String, Person> twoArgsConstructor = Person::new;


	// --- MAIN ---
	public static void main(final String[] args) {

		final Person person = twoArgsConstructor.apply("Patryk", "Grudzien");
		System.out.println(getLastNameFunction.apply(person));

		setAddressFunction.accept(person, "Address");
	}
}
