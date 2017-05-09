import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateParseFormatExample
{
	/*
	 * It's very common to format date into different formats and then parse a String to get Date time objects.
	 */
	public static void main(final String[] args)
	{
		// --- Format examples ---
		final LocalDate date = LocalDate.now();

		// --- Default format ---
		System.out.println("Default format of LocalDate = " + date);

		// --- Specific format ---
		System.out.println(date.format(DateTimeFormatter.ofPattern("d::MMM::uuu")));
		System.out.println(date.format(DateTimeFormatter.BASIC_ISO_DATE));

		final Instant timestamp = Instant.now();

		// --- Default format ---
		System.out.println("Default format of Instant = " + timestamp);

		// --- Parse example ---
		final LocalDateTime dateTime = LocalDateTime.parse("27::Apr::2014 21::39::48",
		                                                   DateTimeFormatter.ofPattern("d::MMM::uuu HH::mm::ss"));
		System.out.println("Default format after parsing = " + dateTime);
	}
}
