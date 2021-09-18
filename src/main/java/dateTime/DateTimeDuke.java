package dateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Deadline:
 *          YYYY-MM-DD Hour(0-23):Minute(0-59)
 *
 * Event:
 *          YYYY-MM-DD Hour(0-23):Minute(0-59) -> YYYY-MM-DD Hour(0-23):Minute(0-59)
 */

public class DateTimeDuke {

    private static LocalDateTime localDateTime;

    public DateTimeDuke(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        localDateTime = LocalDateTime.parse(date, formatter);
    }

    public static String convertToStringTypeI() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d yyyy HH:mm");
        return localDateTime.format(formatter);
    }

    public static String convertToStringTypeII() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return localDateTime.format(formatter);
    }
}
