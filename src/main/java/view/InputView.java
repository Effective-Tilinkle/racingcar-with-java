package view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_MESSAGE = "계산할 값을 입력해 주세요.";
    private static final Scanner sc = new Scanner(System.in);

    public static String inputValue() {
        System.out.println(INPUT_MESSAGE);
        return sc.nextLine();
    }
}
