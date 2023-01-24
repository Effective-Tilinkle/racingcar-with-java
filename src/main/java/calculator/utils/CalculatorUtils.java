package calculator.utils;

public class CalculatorUtils {
    private CalculatorUtils() { }

    public static String[] split(String input) {
        return input.split(" ");
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }
}
