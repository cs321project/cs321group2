/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.Arrays;

/**
 *
 * @author Branch Hill
 */
public class Log {

    public static void Exception(Exception ex) {

        if (ex == null) {
            return;
        }

        String time = DateTimeUtil.GetLocalTimeAsString();
        String source = ex.getClass().toString();
        String stacktrace = Arrays.toString(ex.getStackTrace());
        String message = ex.getMessage();

        System.err.println("********** Exception **********");

        if (time != null) {
            System.err.println("Time: " + time);
        }

        if (source != null) {
            System.err.println("Source: " + source);
        }

        if (message != null) {
            System.err.println("Message: " + message);
        }

        if (message != null) {
            System.err.println("Stack Trace: " + stacktrace);
        }

        System.err.println("*******************************");
    }

    public static void Error(String message) {

        String time = DateTimeUtil.GetLocalTimeAsString();

        if (message == null) {
            return;
        }

        System.err.println("[ERR] " + time + Constants.SINGLE_SPACE + message);
    }

    public static void Warning(String message) {

        String time = DateTimeUtil.GetLocalTimeAsString();

        if (message == null) {
            return;
        }

        System.out.println(Constants.ANSI_YELLOW + "[WRN] " + time
                + Constants.SINGLE_SPACE + message + Constants.ANSI_RESET);
    }

    public static void Information(String message) {

        String time = DateTimeUtil.GetLocalTimeAsString();

        if (message == null) {
            return;
        }

        System.out.println(Constants.ANSI_BLUE + "[INF] " + time
                + Constants.SINGLE_SPACE + message + Constants.ANSI_RESET);
    }

    public static void Debug(String message) {

        String time = DateTimeUtil.GetLocalTimeAsString();

        if (message == null) {
            return;
        }

        System.out.println(Constants.ANSI_BLACK + "[DBG] " + time
                + Constants.SINGLE_SPACE + message + Constants.ANSI_RESET);
    }

    public static void Verbose(String message) {

        String time = DateTimeUtil.GetLocalTimeAsString();

        if (message == null) {
            return;
        }

        System.out.println(Constants.ANSI_GREEN + "[VRB] " + time
                + Constants.SINGLE_SPACE + message + Constants.ANSI_RESET);
    }

}
