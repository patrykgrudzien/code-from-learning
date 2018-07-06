package com.jurik99.Tuple;

import io.vavr.Tuple;
import io.vavr.Tuple2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TupleExample {

	/**
	 * There is no direct equivalent of a tuple data structure in Java. A tuple is a common concept in functional
	 * programming languages.
	 *
	 * Tuples are immutable and can hold multiple objects of different types in a type-safe manner.
	 *
	 * Vavr brings tuples to Java 8. Tuples are of type Tuple1, Tuple2 to Tuple8 depending on the number of elements
	 * they are to take.
	 *
	 * There is currently an upper limit of eight elements. We access elements of a tuple like tuple._n where n is
	 * similar to the notion of an index in arrays:
	 */

	@Test
	public void whenCreatesTuple_thenCorrect1() {
		Tuple2<String, Integer> java8 = Tuple.of("Java", 8);

		/**
		 * Notice that the first element is retrieved with n==1. So a tuple does not use a zero base like an array.
		 * The types of the elements that will be stored in the tuple must be declared in its type declaration.
		 */
		String element1 = java8._1;
		int element2 = java8._2(); // getter is called

		assertEquals("Java", element1);
		assertEquals(8, element2);

		/**
		 * A tuple's place is in storing a fixed group of objects of any type that are better processed as a unit and can be
		 * passed around. A more obvious (use case is returning more than one object from a function or a method) in Java.
		 */
	}
}
