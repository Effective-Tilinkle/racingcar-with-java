package calculator.view;

import java.util.Scanner;

public class InputView {
    public static String getInputValue() {
        try (Scanner scanner = new Scanner(System.in)) {
            return scanner.nextLine();
        }
    }
}
