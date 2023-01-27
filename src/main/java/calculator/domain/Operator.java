package calculator.domain;

import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toUnmodifiableMap;

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

    private static final Map<String, BinaryOperator<Integer>> formulaStorage =
            Stream.of(values())
                    .collect(toUnmodifiableMap(Operator::getOperationSymbol, Operator::getExpression));

    private static void validateDivided(Integer firstValue, Integer secondValue) {
        if (firstValue == 0 || secondValue == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
    }

    public static int operate(int firstValue, String inputSymbol, int secondValue) {
        return getFormula(inputSymbol).apply(firstValue, secondValue);
    }

    private static BinaryOperator<Integer> getFormula(String inputSymbol) {
        return Optional.ofNullable(formulaStorage.get(inputSymbol))
                .orElseThrow(() -> new IllegalArgumentException("사칙 연산 기호가 아닙니다. 입력값을 확인해주세요."));
    }

    public String getOperationSymbol() {
        return operationSymbol;
    }

    public BinaryOperator<Integer> getExpression() {
        return expression;
    }

}
