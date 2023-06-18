package racingcar.step2.view;

public class ResultView {
	private static final String CALCULATE_START_MESSAGE = "계산식을 입력하세요.";
	private static final String CALCULATE_RESULT_FORMAT = "계산식 결과 : %s";

	public static void printCalculateStart() {
		System.out.println(CALCULATE_START_MESSAGE);
	}

	public static void printResult(Integer result) {
		System.out.println(String.format(CALCULATE_RESULT_FORMAT, result));
	}
}
