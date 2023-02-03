package calculator.utils;

public class CalculatorUtils {
    private static final String INPUT_VALUE_EMPTY = "입력 값이 비어 있습니다.";

    private CalculatorUtils() { }

    public static String[] split(String input) {
        validate(input);
        return input.split(" ");
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }

    private static void validate(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(INPUT_VALUE_EMPTY);
        }
    }
}
