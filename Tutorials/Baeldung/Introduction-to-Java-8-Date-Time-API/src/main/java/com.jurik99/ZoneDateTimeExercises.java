package com.jurik99;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Set;

public class ZoneDateTimeExercises {

	public static void main(final String[] args) {

		System.out.println("ZoneId.of(\"Europe/Paris\") = " + ZoneId.of("Europe/Paris"));

		final Set<String> allZoneIds = ZoneId.getAvailableZoneIds();
		allZoneIds.forEach(zoneId -> System.out.println("zoneId = " + zoneId));

		System.out.println("ZonedDateTime.of(LocalDateTime.now(), ZoneId.of(\"US/Pacific\")) = " + ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("US/Pacific")));

		/**
		 * Another way to work with time zone is by using OffsetDateTime. The OffsetDateTime is an immutable representation of a date-time with an offset.
		 * This class stores all date and time fields, to a precision of nanoseconds, as well as the offset from UTC/Greenwich.
		 *
		 * The OffSetDateTime instance can be created as below using ZoneOffset.
		 */
		LocalDateTime localDateTime = LocalDateTime.of(2015, Month.FEBRUARY, 20, 6, 30);
		final ZoneOffset offset = ZoneOffset.of("+02:00");
		System.out.println("OffsetDateTime.of(localDateTime, offset) = " + OffsetDateTime.of(localDateTime, offset));

		System.out.println("--------------------------------------------");

		final ZonedDateTime pacificZoneDateTime = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Pacific/Majuro"));
		System.out.println("pacificZoneDateTime = " + pacificZoneDateTime);
		System.out.println(
				"pacificZoneDateTime.format(DateTimeFormatter.ofPattern(\"HH:MM:SS\")) = " + pacificZoneDateTime.format(DateTimeFormatter.ofPattern("HH:MM:SS")));

		final ZonedDateTime polandZoneDateTime = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Poland"));
		System.out.println("polandZoneDateTime = " + polandZoneDateTime);
		System.out.println(
				"polandZoneDateTime.format(DateTimeFormatter.ofPattern(\"HH:MM:SS\")) = " + polandZoneDateTime.format(DateTimeFormatter.ofPattern("HH:MM:SS")));

		System.out.println(
				"ChronoUnit.MINUTES.between(pacificZoneDateTime, polandZoneDateTime) = " + ChronoUnit.MINUTES.between(pacificZoneDateTime, polandZoneDateTime));

	}
}
