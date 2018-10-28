package com.jurik99.part_3;

import io.vavr.control.Try;

import static io.vavr.API.$;
import static io.vavr.API.Case;
import static io.vavr.API.Match;
import static io.vavr.Patterns.$Failure;
import static io.vavr.Patterns.$Success;

public class JavaSlangExample3 {

	/**
	 * Dopasowania wartości z pierwszej części oraz predykatów z drugiej, to nie jedyne możliwości, jakie daje nam Javaslang.
	 * Dziś przyjrzymy się wzorcom, czyli specjalnym obiektom, które opisują proces dekonstrukcji danego obiektu tak,
	 * by można było go wykorzystać w dopasowaniu. Poznaliśmy już wzorce, które mają znaczenie:
	 * 1) „każdy pasuje” – $(),
	 * oraz
	 * 2) jest „równy w sensie equlas” – $(X).
	 * Standardowe API daje nam jednak kilka innych możliwości.
	 */

	public static void main(final String[] args) {

		successOrFailure();
	}

	/**
	 * ===== Sukces czy Porazka =====
	 * Mamy sobie kontener Try, o którym innym razem.
	 * Może mieć dwa stany – sukces (Success) i porażka (Fail).
	 * Jest to idealny kandydat do obsługi przez mechanizm dopasowań:
	 */

	// Dopasowanie Try
	private static void successOrFailure() {
		final Try<Integer> success = Try.of(() -> 1);
		final Try<Integer> fail = Try.of(() -> {
			throw new Exception("Ni huhu");
		});

		// ------------------------------------------------------------------------------------------------------------------------------
		final Match<Try<Integer>> match = Match(success);

		final Match.Case<Try.Success<Integer>, String> okMatchCase = Case($Success($()), "OK");
		final String ok = match.of(okMatchCase);

		final String wrong = match.of(Case($Failure($()), "WRONG"));
		// ------------------------------------------------------------------------------------------------------------------------------

		System.out.println(Match(success).of(
				Case($Success($()), "OK"),
				Case($Failure($()), "WRONG")
		));

		System.out.println(Match(fail).of(
				Case($Success($()), "OK"),
				Case($Failure($()), "WRONG")
		));
	}

	// Dopasowanie Try z wykorzystaniem wzorców wewnętrznych
	private static void successOrFailure2() {
		final Try<Integer> success = Try.of(() -> 1);
		final Try<Integer> fail = Try.of(() -> {
			throw new IllegalArgumentException("Ni huhu");
		});

		System.out.println(Match(success).of(
				Case($Success($(1)), "1 is OK")
		));
	}
}
