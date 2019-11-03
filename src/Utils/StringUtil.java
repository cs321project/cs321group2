package Utils;

import java.util.List;

public class StringUtil {

    public static String concat(String... args) {
        if (args == null) {
            return null;
        }
        if (args.length == 0) {
            return null;
        }
        String completeString = Constants.EMPTY_STRING;
        for (String arg : args) {
            if (arg != null) {
                completeString = completeString + arg;
            }
        }
        return completeString;
    }

    public static String join(List<String> strings) {
        return join(strings, ", ");
    }

    public static String join(List<String> strings, String seperator) {
        if (strings == null) {
            return null;
        }
        if (strings.isEmpty()) {
            return null;
        }

        String completeString = Constants.EMPTY_STRING;
        for (String string : strings) {
            if (string != null) {
                if (completeString == null ? Constants.EMPTY_STRING == null : completeString.equals(Constants.EMPTY_STRING)) {
                    completeString = string;
                } else {
                    completeString = concat(completeString, seperator, string);
                }
            }
        }
        return completeString;
    }
}
