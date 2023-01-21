package utils;

public class StringUtils {
    private StringUtils() { }

    public static String[] split(String input) {
        return input.split(" ");
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }
}
