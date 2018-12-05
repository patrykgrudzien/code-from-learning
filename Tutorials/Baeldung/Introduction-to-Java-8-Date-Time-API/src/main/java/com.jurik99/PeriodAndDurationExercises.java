package com.jurik99;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodAndDurationExercises {

	public static void main(final String[] args) {

		/**
		 * The {@link java.time.Period} represents a quantity of time in terms of years, months and days.
		 * The {@link java.time.Duration} represents a quantity of time in terms of seconds and nano seconds.
		 */

		// WORKING WITH PERIOD
		final LocalDate initialDate = LocalDate.parse("2007-05-10");
		System.out.println("initialDate = " + initialDate);

		final LocalDate finalDate = initialDate.plus(Period.ofDays(5));
		System.out.println("finalDate = " + finalDate);

		System.out.println("Period.between(finalDate, initialDate).getDays() = " + Period.between(finalDate, initialDate).getDays());
		System.out.println("ChronoUnit.DAYS.between(finalDate, initialDate) = " + ChronoUnit.DAYS.between(finalDate, initialDate));

		System.out.println("--------------------------------------------");

		// WORKING WITH DURATION
		final LocalTime initialTime = LocalTime.of(6, 30, 0);
		System.out.println("initialTime = " + initialTime);

		final LocalTime finalTime = initialTime.plus(Duration.ofSeconds(30));
		System.out.println("finalTime = " + finalTime);

		System.out.println("Duration.between(finalTime, initialTime).getSeconds() = " + Duration.between(finalTime, initialTime).getSeconds());
		System.out.println("ChronoUnit.SECONDS.between(finalDate, initialDate) = " + ChronoUnit.SECONDS.between(finalDate, initialDate));
	}
}
