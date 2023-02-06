package study.racing.step1;

import java.util.Arrays;

public enum Operator {
	PLUS("+"),
	MINUS("-"),
	MULTIPLE("*"),
	DIVIDE("/");

	private static final String INVALID_OPERATOR_MSG = "유효하지 않은 연산자 입니다.";
	private final String operator;

	Operator(String operator) {
		this.operator = operator;
	}

	public static Operator of(String operator) {
		return Arrays.stream(Operator.values())
				.filter(o -> o.operator.equals(operator))
				.findFirst()
				.orElseThrow(() -> new RuntimeException(INVALID_OPERATOR_MSG));
	}
}
