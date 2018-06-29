import java.time.Duration;
import java.time.Instant;

public class InstantExample
{
	/*
	 * Instant class is used to work with machine readable time format, it stores date time in unix timestamp.
	 *
	 * The Instant class in the Java date time API (java.time.Instant) represents a specific moment on the time line.
	 * The instant is defined as an offset since the origin (called an EPOCH).
	 * The ORIGIN is JANUARY 1st 1970 - 00:00 - Greenwhich mean time (GMT).
	 *
	 * Time is measured using 86.400 seconds per day, moving forward from the origin.
	 */
	public static void main(final String[] args)
	{
		// --- Current timestamp ---
		final Instant timestamp = Instant.now();
		System.out.println("Current Timestamp = " + timestamp);

		// --- Instant from timestamp ---
		final Instant specificTime = Instant.ofEpochMilli(timestamp.toEpochMilli());
		System.out.println("Specific Time = " + specificTime);

		// --- Duration example ---
		final Duration thirtyDay = Duration.ofDays(30);
		System.out.println(thirtyDay);
	}
}
