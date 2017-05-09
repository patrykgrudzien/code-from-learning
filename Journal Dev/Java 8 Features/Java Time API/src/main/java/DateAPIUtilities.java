import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.TemporalAdjusters;

public class DateAPIUtilities
{
	/*
	 * As mentioned earlier, most of the Date Time principle classes provide various utility methods such as
	 * plus/minus days, weeks, months etc. There are some other utility methods for adjusting the date using
	 * "TemporatAdjuster" and to calculate the period between two dates.
	 */
	public static void main(final String[] args)
	{
		final LocalDate today = LocalDate.now();

		// --- Get the Year, check if it's leap year ---
		System.out.println("Year " + today.getYear() + " is Leap Year? " + today.isLeapYear());

		// --- Compare two LocalDate for before and after ---
		System.out.println("Today is before 01/01/2018? " + today.isBefore(LocalDate.of(2018, 1, 1)));

		// --- Create LocalDateTime from LocalDate ---
		final LocalDateTime localDateTime = today.atTime(LocalTime.now());
		System.out.println("Current Time = " + localDateTime);

		// --- Plus and minus operations ---
		System.out.println("10 days after today will be = " + today.plusDays(10));
		System.out.println("3 weeks after today will be = " + today.plusWeeks(3));
		System.out.println("20 months after today will be = " + today.plusMonths(20));

		System.out.println("10 days before today will be = " + today.minusDays(10));
		System.out.println("3 weeks before today will be = " + today.minusWeeks(3));
		System.out.println("20 months before today will be = " + today.minusMonths(20));

		// --- Temporal adjusters for adjusting the dates ---
		final LocalDate firstDayOfMonth = today.with(TemporalAdjusters.firstDayOfMonth());
		System.out.println("First date of this month = " + firstDayOfMonth);

		final LocalDate lastDayOfYear = today.with(TemporalAdjusters.lastDayOfYear());
		System.out.println("Last date of this year = " + lastDayOfYear);

		final Period period = today.until(lastDayOfYear);
		System.out.println("Period format = " + period);
		System.out.println("Months remaining in the year = " + period.getMonths());
	}
}
