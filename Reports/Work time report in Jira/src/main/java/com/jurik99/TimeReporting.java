package com.jurik99;

import java.math.BigDecimal;

public class TimeReporting implements Colorable
{
	private static final BigDecimal THREE = BigDecimal.valueOf(3);
	private static final BigDecimal FIVE = BigDecimal.valueOf(5);
	private static final BigDecimal HUNDRED = BigDecimal.valueOf(100);
	private static final BigDecimal HOURS_TO_WORK = BigDecimal.valueOf(8);
	private static double workedHours;

	public static boolean validateDayWork(final boolean isDisplayInMinutes, final boolean isDisplayInHours)
	{
		if (isDisplayInMinutes & isDisplayInHours)
		{
			System.err.println("Select only ONE display unit !!!");
		}
		else if (isDisplayInMinutes)
		{
			if (workedHours < HOURS_TO_WORK.doubleValue())
			{
				final BigDecimal leftTime = HOURS_TO_WORK.subtract(BigDecimal.valueOf(workedHours));
				final BigDecimal minutes = leftTime.multiply(HUNDRED).multiply(THREE).divide(FIVE, 0, BigDecimal.ROUND_CEILING);
				System.out.println(RED + "You should report MORE " + minutes + " minutes." + RESET);
			}
			else if (workedHours > HOURS_TO_WORK.doubleValue())
			{
				final BigDecimal leftTime = BigDecimal.valueOf(workedHours).subtract(HOURS_TO_WORK);
				final BigDecimal minutes = leftTime.multiply(HUNDRED).multiply(THREE).divide(FIVE, 0, BigDecimal.ROUND_DOWN);
				System.out.println(GREEN + "You reported EXTRA " + minutes + " minutes. CHANGE IT !" + RESET);
			}
			else if ((int) workedHours == HOURS_TO_WORK.doubleValue())
			{
				System.out.println("You worked 8h today :)");
				return true;
			}
			return false;
		}
		else if (isDisplayInHours)
		{
			if (workedHours < HOURS_TO_WORK.doubleValue())
			{
				final BigDecimal leftTime = HOURS_TO_WORK.subtract(BigDecimal.valueOf(workedHours));
				final BigDecimal hour = BigDecimal.valueOf(Math.floor(leftTime.doubleValue()));
				final BigDecimal minutes = leftTime.subtract(hour).multiply(HUNDRED).multiply(THREE).divide(FIVE, 0, BigDecimal.ROUND_CEILING);
				System.out.println(RED + "You should report MORE " + hour.intValue() + " hour and " + minutes + " minutes." + RESET);
			}
			else if (workedHours > HOURS_TO_WORK.doubleValue())
			{
				final BigDecimal leftTime = BigDecimal.valueOf(workedHours).subtract(HOURS_TO_WORK);
				final BigDecimal hour = BigDecimal.valueOf(Math.floor(leftTime.doubleValue()));
				final BigDecimal minutes = leftTime.subtract(hour).multiply(HUNDRED).multiply(THREE).divide(FIVE, 0, BigDecimal.ROUND_DOWN);
				System.out.println(GREEN + "You reported EXTRA " + hour.intValue() + " hour and " + minutes + " minutes. CHANGE IT !" + RESET);
			}
			else if ((int) workedHours == HOURS_TO_WORK.doubleValue())
			{
				System.out.println("You worked 8h today :)");
				return true;
			}
			return false;
		}
		return false;
	}

	public static void reportTimeInMinutes(final String task, final double minutes)
	{
		final BigDecimal bigMinutes = BigDecimal.valueOf(minutes).divide(BigDecimal.valueOf(100), 2, BigDecimal.ROUND_CEILING);
		final BigDecimal tempMinutes = bigMinutes.multiply(FIVE).divide(THREE, 2, BigDecimal.ROUND_CEILING);
		System.out.println("In task: " + task + " you should report " + tempMinutes + "h");
		workedHours += tempMinutes.doubleValue();
	}

	public static void reportTimeInHours(final String task, final double hours_point_minutes)
	{
		final BigDecimal bigHours = BigDecimal.valueOf(hours_point_minutes);
		final BigDecimal fullNumberOfHours = BigDecimal.valueOf(Math.floor(hours_point_minutes));
		final BigDecimal minutesToConvert = bigHours.subtract(fullNumberOfHours);
		final BigDecimal tempMinutes = minutesToConvert.multiply(FIVE).divide(THREE, 2, BigDecimal.ROUND_CEILING);
		final BigDecimal finalResult = fullNumberOfHours.add(tempMinutes);
		System.out.println("In task: " + task + " you should report " + finalResult + " h");
		workedHours += finalResult.doubleValue();
	}
}