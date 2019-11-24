package Utils;

/**
 *
 * @author Branch Hill
 */
public class RandomUtil {

    /**
     *
     * @param min
     * @param max
     * @return
     * @throws Exception
     */
    public static int getRandomIntegerBetweenRange(int min, int max) throws Exception {
        if (min < 0 || max < 0) {
            throw new Exception("min and max cannot be negative values");
        }
        if (min > max) {
            throw new Exception("min must be less than max");
        }
        int x = (int) (Math.random() * ((max - min) + 1)) + min;
        return x;
    }
}
