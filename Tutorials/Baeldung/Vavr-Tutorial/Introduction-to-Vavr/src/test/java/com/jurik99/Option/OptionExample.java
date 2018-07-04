package com.jurik99.Option;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import io.vavr.control.Option;

import org.junit.Test;

public class OptionExample {

	/**
	 * The main goal of {@link io.vavr.control.Option} is to eliminate null checks in our code by leveraging the Java type system.
	 * Option is an object container in Vavr with a similar end goal like {@link java.util.Optional} in Java 8.
	 * Vavr's Option implements:
	 * - {@link java.io.Serializable}
	 * - {@link Iterable}
	 * and has a richer API.
	 */

	@Test
	public void givenValue_whenNullCheckNeeded_thanCorrect() {
		Object object = null;
		if (object == null) {
			object = "someDefaultValue";
		}
		assertNotNull(object);
	}

	@Test(expected = NullPointerException.class)
	public void givenValue_whenNullCheckNeeded_thenCorrect2() {
		Object possibleNullObj = null;
		assertEquals("someValue", possibleNullObj.toString());
	}

	/**
	 * {@link io.vavr.control.Option} solves this problem by totally eliminating "nulls" and replacing them with a valid object
	 * reference for each possible scenario.
	 * With "Option" a null value will evaluate to an instance of {@link io.vavr.control.Option.None}, while a non-null value
	 * will evaluate to an instance of {@link io.vavr.control.Option.Some}
	 */

	@Test
	public void givenValue_whenCreatesOption_thenCorrect() {
		Option<Object> noneOption = Option.of(null);
		Option<Object> someOption = Option.of("val");

		assertEquals("None", noneOption.toString());
		assertEquals("Some(val)", someOption.toString());
		// Option's toString() returns us meaningful values in each call
	}

	/**
	 * In the second snippet of this section, we needed a null check, in which we would assign a default value to the variable,
	 * before attempting to use it. Option can deal with this in a single line, even if there is a null:
	 */
	@Test
	public void givenNull_whenCreatesOption_thenCorrect() {
		String name = null;
		Option<String> nameOption = Option.of(name);

		assertEquals("patryk", nameOption.getOrElse("patryk"));
	}

	/**
	 * Or a non-null:
	 */
	@Test
	public void givenNonNull_whenCreatesOption_thenCorrect() {
		String name = "patryk";
		Option<String> nameOption = Option.of(name);

		assertEquals("patryk", nameOption.getOrElse("patryk"));
		// notice how, without null checks, we can get a value or return a default in a single line
	}
}
