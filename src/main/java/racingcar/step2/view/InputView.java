package racingcar.step2.view;

import java.io.InputStream;
import java.util.Scanner;

public class InputView {
	private static final String INVALID_INPUT_MESSAGE = "입력값이 유효하지 않습니다.";
	public static String inputExpression(InputStream input) {
		String inputString = new Scanner(input).nextLine();
		validate(inputString);
		return inputString;
	}

	private static void validate(String input) {
		if (input == null || "".equals(input)) {
			throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
		}
	}
}
