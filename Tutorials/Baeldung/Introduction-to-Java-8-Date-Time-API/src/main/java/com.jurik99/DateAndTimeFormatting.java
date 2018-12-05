package com.jurik99;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class DateAndTimeFormatting {

	public static void main(final String[] args) {

		final LocalDateTime localDateTime = LocalDateTime.of(2015, Month.JANUARY, 26, 6, 30);

		System.out.println("localDateTime.format(DateTimeFormatter.ISO_DATE) = " + localDateTime.format(DateTimeFormatter.ISO_DATE));

		System.out.println("localDateTime.format(DateTimeFormatter.ofPattern(\"yyyy/MM/dd\")) = " + localDateTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));

		System.out.println("localDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(Locale.UK)) = " +
		                   localDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(Locale.UK)));
	}
}
