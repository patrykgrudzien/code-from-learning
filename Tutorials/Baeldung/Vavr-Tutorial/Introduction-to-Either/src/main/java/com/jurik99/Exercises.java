package com.jurik99;

import io.vavr.control.Either;
import io.vavr.control.Option;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Exercises {

	/**
	 * {@link io.vavr.control.Either} represents a value of two possible data types.
	 * An {@link io.vavr.control.Either} is either a {@link io.vavr.control.Either.Left} or a {@link io.vavr.control.Either.Right}.
	 * By convention, the {@link io.vavr.control.Either.Left} signifies a failure case result and the
	 * {@link io.vavr.control.Either.Right} signifies a success.
	 */

	public static void main(final String[] args) {

		final Map<String, Object> results = computeWithoutEitherUsingMap(8);
		System.out.println("results.get(\"FAILURE\") = " + results.get("FAILURE"));
		System.out.println("results.get(\"SUCCESS\") = " + results.get("SUCCESS"));

		System.out.println("computeWithEither(8) = " + computeWithEither(8));

		/*
		 * By convention, Either's Left attribute represents a failure and the Right one represents a success.
		 * However, based on our needs we can change this using projections - Either in Vavr is not biased towards Left or Right.
		 *
		 * If we project to Right, operations like filter(), map() will have no effect if Either was Left.
		 */

		// for example, let's create the Right projection and define some operations on it:
		// right() is @deprecated! Either is right-biased so there is no need to use right() method here!
		final List<Integer> integerList = computeWithEither(120)
				                                  .filter(integer -> integer > 100)
				                                  .map(integers -> integers.toStream().collect(Collectors.toList()))
				                                  .orElse(Option.none())
				                                  .get();
		System.out.println("integerList.size() = " + integerList.size());

		final Either<String, Integer> computeWith80 = computeWithEither(80);
		System.out.println("computeWithEither(80).isLeft() = " + computeWith80.isLeft());
		System.out.println("computeWithEither(80).isRight() = " + computeWith80.isRight());

		// we can "fold" Left and Right to one common type:
		final Either<String, Integer> either = Either.right(42);
		final String fold = either.fold(Function.identity(), Object::toString);
		System.out.println("fold = " + fold);
	}

	@SuppressWarnings("SameParameterValue")
	private static Map<String, Object> computeWithoutEitherUsingMap(final int marks) {
		final Map<String, Object> results = new HashMap<>();
		if (marks < 85) {
			results.put("FAILURE", "Marks not acceptable!");
		} else {
			results.put("SUCCESS", marks);
		}
		return results;
	}

	// with Either
	@SuppressWarnings("SameParameterValue")
	private static Either<String, Integer> computeWithEither(final int marks) {
		return marks < 85 ?
				       Either.left("Marks not acceptable!") :
				       Either.right(marks);
	}
}
