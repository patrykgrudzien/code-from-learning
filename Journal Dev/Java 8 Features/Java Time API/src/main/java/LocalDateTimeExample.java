import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class LocalDateTimeExample
{
	/*
	 *  LocalDateTime is an immutable date-time object that represents a date-time, with default format as
	 *  yyyy-MM-dd-HH-mm-ss.zzz. It provides a factory method that takes LocalDate and LocalTime input arguments to
	 *  create LocalDateTime instance.
	 */

	public static void main(final String[] args)
	{
		// --- Current Date ---
		LocalDateTime today = LocalDateTime.now();
		System.out.println("Current DateTime = " + today);

		// --- Current Date using LocalDate and LocalTime ---
		today = LocalDateTime.of(LocalDate.now(), LocalTime.now());
		System.out.println("Current DateTime = " + today);

		// --- Creating LocalDateTime by providing input arguments ---
		final LocalDateTime specificDate = LocalDateTime.of(2014, Month.JANUARY, 1, 10, 10, 30);
		System.out.println("Specific Date = " + specificDate);

		/*
		 * We have seen so far that if we provide invalid arguments for creating Date/Time, then it throws
		 * "java.time.DateTimeException" that is a RuntimeException, so we don't need to explicitly catch it.
		 *
		 * We have also seen that we can get Date/Time data by passing "ZoneId". You can get the list of supported
		 * ZoneId values from it's javadoc.
		 */
	}
}
