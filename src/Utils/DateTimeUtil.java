package Utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Branch Hill
 */
public class DateTimeUtil {

    /**
     * Gets the local time as a string value
     *
     * @return Local time as string
     */
    public static String getLocalTimeAsString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String time = dtf.format(now);
        if (time == null) {
            return Constants.EMPTY_STRING;
        }
        return time;
    }

    /**
     * Gets the local DateTime as a string
     * @return Local DateTime as string
     */
    public static String getLocalDateTimeAsString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String time = dtf.format(now);
        if (time == null) {
            return Constants.EMPTY_STRING;
        }
        return time;
    }
}
