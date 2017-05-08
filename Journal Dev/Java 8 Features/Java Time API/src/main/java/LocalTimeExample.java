import java.time.LocalTime;
import java.time.ZoneId;

public class LocalTimeExample
{
	/*
	 *  LocalTime is an immutable class whose instance represents a time in the human readable format.
	 *  It’s default format is hh:mm:ss.zzz. Just like LocalDate, this class provides time zone support and
	 *  creating instance by passing hour, minute and second as input arguments.
	 */

	public static void main(final String[] args)
	{
		// --- Current Time ---
		final LocalTime time = LocalTime.now();
		System.out.println("Current Time = " + time);

		// --- Creating LocalTime by providing input arguments ---
		final LocalTime specificTime = LocalTime.of(12, 20, 25, 40);
		System.out.println("Specific Time of Day = " + specificTime);

		/*
		 * Try creating time by providing invalid inputs:
		 * LocalTime invalidTime = LocalTime.of(25,20);
		 * Exception in thread "main" java.time.DateTimeException:
		 * Invalid value for HourOfDay (valid values 0 - 23): 25
		 */

		final LocalTime timeKolkata = LocalTime.now(ZoneId.of("Asia/Kolkata"));
		System.out.println("Current Time in IST = " + timeKolkata);
	}
}
