package com.jurik99;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class LocalDateExercises {

	public static void main(final String[] args) {

		// ISO format (yyyy-MM-dd) without time
		System.out.println("LocalDate.now() = " + LocalDate.now());

		// LocalDate of specific year, month and day
		System.out.println("LocalDate.of(2018, 2, 20) = " + LocalDate.of(2018, 2, 20));
		System.out.println("LocalDate.of(2018, Month.AUGUST, 20) = " + LocalDate.of(2018, Month.AUGUST, 20));

		// LocalDate provides various utility methods
		System.out.println("LocalDate.now().plusDays(1) = " + LocalDate.now().plusDays(1));

		System.out.println("LocalDate.now().minus(1, ChronoUnit.MONTHS) = " + LocalDate.now().minus(1, ChronoUnit.MONTHS));

		System.out.println("LocalDate.parse(\"2018-08-26\").getDayOfWeek() = " + LocalDate.parse("2018-08-26").getDayOfWeek());
		System.out.println("LocalDate.parse(\"2018-08-26\").getDayOfMonth() = " + LocalDate.parse("2018-08-26").getDayOfMonth());

		System.out.println("LocalDate.now().isLeapYear() = " + LocalDate.now().isLeapYear());

		System.out.println(
				"LocalDate.parse(\"2016-06-12\").isBefore(LocalDate.parse(\"2016-06-11\")) = " + LocalDate.parse("2016-06-12").isBefore(LocalDate.parse("2016-06-11")));

		System.out.println(
				"LocalDate.parse(\"2016-06-12\").isAfter(LocalDate.parse(\"2016-06-11\")) = " + LocalDate.parse("2016-06-12").isAfter(LocalDate.parse("2016-06-11")));

		System.out.println("LocalDate.parse(\"2016-06-12\").atStartOfDay() = " + LocalDate.parse("2016-06-12").atStartOfDay());

		System.out.println(
				"LocalDate.parse(\"2016-06-12\").with(TemporalAdjusters.firstDayOfMonth()) = " + LocalDate.parse("2016-06-12").with(TemporalAdjusters.firstDayOfMonth()));
	}
}
