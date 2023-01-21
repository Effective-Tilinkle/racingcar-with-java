package calculator.view;

public class OutputView {
    private static final String RESULT_MESSAGE = "결괏값 : %d";

    private OutputView() { }

    public static void printResult(int result) {
        System.out.println(String.format(RESULT_MESSAGE, result));
    }
}
