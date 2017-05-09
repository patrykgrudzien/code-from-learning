import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateAPILegacySupport
{
	/*
	 *  LEGACY - przestarzały
	 *  VERBOSE - rozwlekły
	 *
	 *  Legacy Date/Time classes are used in almost all the applications, so having backward compatibility is a must.
	 *  That's why there are several utility methods through which we can convert Legacy classes to new classes and
	 *  vice versa.
	 */
	public static void main(final String[] args)
	{
		// --- Date to Instant ---
		final Instant timestamp = new Date().toInstant();

		// --- Now we can convert Instant to LocalDateTime or other similar classes ---
		final LocalDateTime date = LocalDateTime.ofInstant(timestamp, ZoneId.of(ZoneId.SHORT_IDS.get("PST")));

		System.out.println("Date = " + date);

		// --- Calendar to Instant ---
		final Instant time = Calendar.getInstance().toInstant();
		System.out.println("Time = " + time);

		// --- TimeZone to ZoneId ---
		final ZoneId defaultZoneId = TimeZone.getDefault().toZoneId();
		System.out.println("Default ZoneID = " + defaultZoneId);    // Europe/Belgrade

		// --- ZoneDateTime from specific Calendar ---
		final ZonedDateTime gregorianCalendarDatetime = new GregorianCalendar().toZonedDateTime();
		System.out.println("new GregorianCalendar().toZonedDateTime() = " + gregorianCalendarDatetime);

		// --- Date API to Legacy classes ---
		final Date dt = Date.from(Instant.now());
		System.out.println(dt);

		final TimeZone tz = TimeZone.getTimeZone(defaultZoneId);
		System.out.println(tz);

		final GregorianCalendar gregorianCalendar = GregorianCalendar.from(gregorianCalendarDatetime);
		System.out.println(gregorianCalendar);

		/*
		 * As you can see that legacy "TimeZone" and "GregorianCalendar" classes "toString()" methods are too verbose
		 * and not user friendly.
		 */
	}
}
