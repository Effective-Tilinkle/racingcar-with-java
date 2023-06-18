package step2;

import java.util.Scanner;
import java.util.regex.Pattern;

import step2.Operator;

public class StringCalculator {

	private static final Pattern PATTERN = Pattern.compile("(\\d+(\\s[+\\-*/]\\s\\d+)*\\s*)"); // 숫자공백연산자공백숫자 형식의 정규식
	private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]+$");
	private static final String SEPARATOR = " ";
	private static final String DEFAULT_OPERATOR = "+";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("input: ");
		String expression = scanner.nextLine();
		scanner.close();

		try {
			int result = calculateExpression(expression);
			System.out.println("result: " + result);
		} catch (IllegalArgumentException e) {
			System.err.println("Calculation is not valid: " + e.getMessage());
		}
	}

	public static int calculateExpression(String expression) throws IllegalArgumentException {

		if (!PATTERN.matcher(expression).matches()) {
			throw new IllegalArgumentException("Invalid expression!");
		}

		String[] tokens = expression.split(SEPARATOR);
		int result = 0;
		String operator = DEFAULT_OPERATOR;

		for (String token : tokens) {
			if (NUMBER_PATTERN.matcher(token).matches()) {
				result = performOperation(result, Integer.parseInt(token), operator);
			}
			operator = token;
		}

		return result;
	}

	public static int performOperation(int result, int number, String lastOperator) {
		Operator operator = Operator.getOperatorFromString(lastOperator);
		return operator.apply(result, number);
	}

}
