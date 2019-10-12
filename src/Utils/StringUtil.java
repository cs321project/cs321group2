package Utils;

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
}
