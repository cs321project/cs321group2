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
     * @return
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
}
