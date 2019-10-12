package Utils;

import java.util.Arrays;
import java.util.Scanner;

public class Log {

    public static void exception(Exception ex) {
        if (ex == null) {
            return;
        }
        String time = DateTimeUtil.getLocalTimeAsString();
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

    public static void error(String message) {
        String time = DateTimeUtil.getLocalTimeAsString();
        if (message == null) {
            return;
        }
        System.err.println("[ERR] " + time + Constants.SINGLE_SPACE + message);
    }

    public static void warning(String message) {
        String time = DateTimeUtil.getLocalTimeAsString();
        if (message == null) {
            return;
        }
        System.out.println(Constants.ANSI_YELLOW + "[WRN] " + time + Constants.SINGLE_SPACE + message + Constants.ANSI_RESET);
    }

    public static void information(String message) {
        String time = DateTimeUtil.getLocalTimeAsString();
        if (message == null) {
            return;
        }
        System.out.println(Constants.ANSI_BLUE + "[INF] " + time + Constants.SINGLE_SPACE + message + Constants.ANSI_RESET);
    }

    public static void debug(String message) {
        String time = DateTimeUtil.getLocalTimeAsString();
        if (message == null) {
            return;
        }
        System.out.println(Constants.ANSI_BLACK + "[DBG] " + time + Constants.SINGLE_SPACE + message + Constants.ANSI_RESET);
    }

    public static void verbose(String message) {
        String time = DateTimeUtil.getLocalTimeAsString();
        if (message == null) {
            return;
        }
        System.out.println(Constants.ANSI_GREEN + "[VRB] " + time + Constants.SINGLE_SPACE + message + Constants.ANSI_RESET);
    }

    public static void output(String message) {
        if (message == null) {
            return;
        }
        message = StringUtil.concat(Constants.ANSI_BLACK, message, Constants.ANSI_RESET);
        if (message == null) {
            return;
        }
        if (message.isEmpty()) {
            return;
        }
        System.out.println(message);
    }

    public static String getInputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int getInputInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
