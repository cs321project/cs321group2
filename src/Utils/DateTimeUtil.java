/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Group 2
 */
public class DateTimeUtil {

    public static String GetLocalTimeAsString() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String time = dtf.format(now);

        if (time == null) {
            return Constants.EMPTY_STRING;
        }

        return time;
    }

}
