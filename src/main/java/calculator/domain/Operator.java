package calculator.domain;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operator {
    PLUS ("+", (firstValue, secondValue) -> firstValue + secondValue),
    MINUS ("-", (firstValue, secondValue) -> firstValue - secondValue),
    MULTIPLY ("*", (firstValue, secondValue) -> firstValue * secondValue),
    DIVIDED ("/", (firstValue, secondValue) -> {
        validateDivided(firstValue, secondValue);
        return firstValue / secondValue;
    });

    private final String operationSymbol;
    private final BinaryOperator<Integer> expression;

    Operator(String operationSymbol, BinaryOperator<Integer> expression) {
        this.operationSymbol = operationSymbol;
        this.expression = expression;
    }

    private static void validateDivided(Integer firstValue, Integer secondValue) {
        if (firstValue == 0 || secondValue == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
    }

    public static int operate(String inputSymbol, int firstValue, int secondValue) {
        return findSymbols(inputSymbol).expression.apply(firstValue, secondValue);
    }

    private static Operator findSymbols(String inputSymbol) {
        return Arrays.stream(values())
                .filter(operator -> operator.operationSymbol.equals(inputSymbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("사칙 연산 기호가 아닙니다. 입력값을 확인해주세요."));
    }
}
