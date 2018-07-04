package com.jurik99.Try;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.vavr.control.Try;

import org.junit.Test;

public class TryExample {

	/**
	 * In Vavr, Try is a container for a computation which may result in an exception.
	 *
	 * As Option wraps a nullable object so that we don’t have to explicitly take care of nulls with if checks,
	 * Try wraps a computation so that we don’t have to explicitly take care of exceptions with try-catch blocks.
	 */
	@Test(expected = ArithmeticException.class)
	public void givenBadCode_whenThrowsException_thenCorrect() {
		int i = 1 / 0;
	}

	/**
	 * Without try-catch blocks, the application would crash. In order to avoid this, you would need to wrap the statement
	 * in a try-catch block.
	 * With Vavr, we can wrap the same code in a Try instance and get a result:
	 */
	@Test
	public void givenBadCode_whenTryHandles_thenCorrect() {
		Try<Integer> result = Try.of(() -> 1 / 0);

		assertTrue(result.isFailure());
	}

	/**
	 * Whether the computation was successful or not can then be inspected by choice at any point in the code.
	 * In the above snippet, we have chosen to simply check for success or failure. We can also choose to return a default value:
	 */
	@Test
	public void givenBadCode_whenTryHandles_thenCorrect2() {
		Try<Integer> computation = Try.of(() -> 1 / 0);
		int error = computation.getOrElse(-1);

		assertEquals(-1, error);
	}

	/**
	 * Or even to explicitly throw an exception of our choice:
	 */
	@Test(expected = ArithmeticException.class)
	public void givenBadCode_whenTryHandles_thenCorrect3() {
		Try<Integer> result = Try.of(() -> 1 / 0);
		result.getOrElseThrow(() -> new ArithmeticException("EXCEPTION"));
	}
}
