package racingcar.step2.domain;

public class Calculator {
	private static final String INVALID_EXPRESSION_MESSAGE = "올바르지 않은 식입니다.";
	private static final String DELIMITER = " ";

	private final String[] tokens;

	public Calculator(String input) {
		String[] tokens = input.split(DELIMITER);
		if (tokens.length % 2 == 0) {
			throw new IllegalArgumentException(INVALID_EXPRESSION_MESSAGE);
		}
		this.tokens = tokens;
	}

	public Operand calculate() {
		Operand leftOperand = Operand.of(tokens[0]);

		for (int i=1; i<tokens.length; i+=2) {
			Operator operator = Operator.of(tokens[i]);
			Operand rightOperand = Operand.of(tokens[i + 1]);
			leftOperand = operator.operation(leftOperand, rightOperand);
		}

		return leftOperand;
	}
}
