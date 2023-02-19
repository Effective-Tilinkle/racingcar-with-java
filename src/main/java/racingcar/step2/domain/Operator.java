package racingcar.step2.domain;

import java.util.Arrays;

public enum Operator {
	PLUS("+", Operand::plus),
	MINUS("-", Operand::minus),
	MULTIPLE("*", Operand::multiple),
	DIVIDE("/", Operand::divide);

	private static final String INVALID_OPERATOR_MESSAGE = "유효하지 않은 연산자 입니다.";
	private final String operator;
	private final OperatorProcess operatorProcess;

	Operator(String operator, OperatorProcess operatorProcess) {
		this.operator = operator;
		this.operatorProcess = operatorProcess;
	}

	public static Operator of(String operator) {
		return Arrays.stream(Operator.values())
					 .filter(o -> o.operator.equals(operator))
					 .findFirst()
					 .orElseThrow(() -> new IllegalArgumentException(INVALID_OPERATOR_MESSAGE));
	}

	public Operand operation(Operand leftOperand, Operand rightOperand) {
		return this.operatorProcess.process(leftOperand, rightOperand);
	}
}
