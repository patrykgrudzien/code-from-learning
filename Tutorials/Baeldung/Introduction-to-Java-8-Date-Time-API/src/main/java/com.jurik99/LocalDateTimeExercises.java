package com.jurik99;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Date;

public class LocalDateTimeExercises {

	public static void main(final String[] args) {

		// The "LocalDateTime" is used to represent a combination of date and time
		System.out.println("LocalDateTime.now() = " + LocalDateTime.now());
		System.out.println("new Date() = " + new Date());

		System.out.println("LocalDateTime.of(2018, Month.DECEMBER, 5, 10, 30) = " + LocalDateTime.of(2018, Month.DECEMBER, 5, 10, 30));

		System.out.println("LocalDateTime.parse(\"2018-10-05T10:30:00\") = " + LocalDateTime.parse("2018-12-05T10:30:00"));

		System.out.println("LocalDateTime.now().plusDays(1) = " + LocalDateTime.now().plusDays(1));

		System.out.println("LocalDateTime.now().minusHours(2) = " + LocalDateTime.now().minusHours(2));

		System.out.println("LocalDateTime.now().getMonth() = " + LocalDateTime.now().getMonth());
	}
}
