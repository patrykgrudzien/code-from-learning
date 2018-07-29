package com.jurik99.part_2;

import static io.vavr.API.$;
import static io.vavr.API.Case;
import static io.vavr.API.Match;
import static io.vavr.API.run;
import static io.vavr.Predicates.anyOf;
import static io.vavr.Predicates.instanceOf;
import static io.vavr.Predicates.is;
import static io.vavr.Predicates.isIn;
import static io.vavr.Predicates.noneOf;

public class JavaSlangExample2 {

	public static void main(final String[] args) {

		predicates();
		preDefinedPredicates();
		returningValues();
		running();
	}

	private static void predicates() {
		final Integer i = 0;
		String on = Match(i).of(
				Case($(objectToBePredicated -> objectToBePredicated == 1), "ONE"),
				Case($(objectToBePredicated -> objectToBePredicated == 2), "TWO"),
				Case($(), "?")
		);
		System.out.println("Predicate with lambda -> " + on);
	}

	private static void preDefinedPredicates() {
		final Object i = 0;
		final String on = Match(i).of(
				Case($(is(1)), "1"),
				Case($(isIn(2, 3)), "2 or 3"),
				Case($(anyOf(is(4), noneOf(is(5), is(6)))), "4 or NOT (5 or 6)"),
				Case($(instanceOf(String.class)), "Some Text"),
				Case($(), "?")
		);
		System.out.println(on);
	}

	// WARTOŚCI ZWRACANE
	private static void returningValues() {
		final Integer i = 1;
		final String on = Match(i).of(
				Case($(1), input -> input + " displayed."),
				Case($(2), () -> "Dwa"),
				Case($(), "?")
		);
		System.out.println("Returning Values -> " + on);
	}

	/**
	 * Efektywnie (Match) zachowuje sie jak wyrazenie i musi zwrocic wartosc. Co w przypadku gdy zamiast zwracania wartosci chcemy
	 * wykonac jakas czynnosc? W tym przypadku musimy uzyc metody pomocniczej "run()":
	 */
	private static void running() {
		final Integer i = 1;
		Match(i).of(
				Case($(1), input -> run(() -> System.out.println(input))),
				Case($(2), input -> run(() -> System.out.println(input))),
				Case($(), () -> null)
		);
	}
	/**
	 * Krytycznym wymaganiem jest opakowanie "run()" w (Supplier). W przeciwnym wypadku zostanie on uruchomiony przed procedura dopasowania !
	 * Dlaczego?
	 * Poniewaz ewaluacja parametrow w Javie jest zachłanna.
	 */
}
