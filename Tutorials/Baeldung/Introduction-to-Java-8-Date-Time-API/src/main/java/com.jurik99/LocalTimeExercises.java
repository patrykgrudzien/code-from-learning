package com.jurik99;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class LocalTimeExercises {

	public static void main(final String[] args) {

		// The "LocalTime" represents time without a date
		System.out.println("LocalTime.now() = " + LocalTime.now());

		System.out.println("LocalTime.parse(\"06:30\") = " + LocalTime.parse("06:30"));

		System.out.println("LocalTime.of(6, 30) = " + LocalTime.of(6, 30));

		System.out.println("LocalTime.parse(\"06:30\").plus(1, ChronoUnit.HOURS) = " + LocalTime.parse("06:30").plus(1, ChronoUnit.HOURS));

		System.out.println("LocalTime.parse(\"06:30\").getHour() = " + LocalTime.parse("06:30").getHour());

		System.out.println("LocalTime.parse(\"06:30\").isBefore(LocalTime.parse(\"07:30\")) = " + LocalTime.parse("06:30").isBefore(LocalTime.parse("07:30")));

		System.out.println("LocalTime.MAX = " + LocalTime.MAX);
		System.out.println("LocalTime.MIN = " + LocalTime.MIN);
		System.out.println("LocalTime.MIDNIGHT = " + LocalTime.MIDNIGHT);
	}
}
