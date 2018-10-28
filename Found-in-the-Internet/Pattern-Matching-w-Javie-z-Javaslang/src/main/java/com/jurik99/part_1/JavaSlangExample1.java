package com.jurik99.part_1;

import io.vavr.control.Option;

import static io.vavr.API.$;
import static io.vavr.API.Case;
import static io.vavr.API.Match;

public class JavaSlangExample1 {

	public static void main(final String[] args) {

		ifology();
		introduction();
		noneMatchingCaseWithOption();
	}

	@SuppressWarnings("ConstantConditions")
	private static void ifology() {
		final Integer i = 0;
		String on;
		if (i == 1) {
			on = "ONE";
		} else if (i == 2) {
			on = "TWO";
		} else {
			on = "?";
		}
		System.out.println(on);
	}

	private static void introduction() {
		final Integer i = 0;
		final String on = Match(i).of(
				Case($(1), "ONE"),
				Case($(2), "ONE"),
				Case($(), "?")
		);
		System.out.println("Vavr -> " + on);
	}

	private static void noneMatchingCaseWithOption() {
		final Integer i = 0;
		final Option<String> option = Match(i).option(
				Case($(1), "ONE"),
				Case($(2), "TWO")
		);
		System.out.println("Option -> " + option);
	}
}
