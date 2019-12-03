package Utils;

import java.util.List;

/**
 *
 * @author Branch Hill
 */
public class StringUtil {

    /**
     * Concatenates strings
     * @param args
     * @return string
     */
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

    /**
     * joins string in a specified format
     * @param strings
     * @return string
     */
    public static String join(List<String> strings) {
        return join(strings, ", ");
    }

    /**
     * joins string in a specified format
     * @param strings
     * @param seperator
     * @return string 
     */
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
