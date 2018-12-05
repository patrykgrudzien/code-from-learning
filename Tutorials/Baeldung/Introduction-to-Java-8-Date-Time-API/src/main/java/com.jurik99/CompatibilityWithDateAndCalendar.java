package com.jurik99;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.GregorianCalendar;

public class CompatibilityWithDateAndCalendar {

	public static void main(final String[] args) {

		/**
		 * Java 8 has added the: "toInstant()" method which helps to convert existing
		 * {@link java.util.Date} and {@link java.util.Calendar} to new Date Time API.
		 */

		System.out.println(
				"LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault()) = " + LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault()));

		System.out.println(
				"LocalDateTime.ofInstant(new GregorianCalendar().toInstant(), ZoneId.systemDefault()) = "
				+ LocalDateTime.ofInstant(new GregorianCalendar().toInstant(), ZoneId.systemDefault()));

		/**
		 * The LocalDateTime can be constructed from epoch seconds as below.
		 * The result of the below code would be a LocalDateTime representing 2016-06-13T11:34:50.
		 */
		System.out.println("LocalDateTime.ofEpochSecond(1465817690, 0, ZoneOffset.UTC) = " +
		                   LocalDateTime.ofEpochSecond(1465817690, 0, ZoneOffset.UTC));
	}
}
