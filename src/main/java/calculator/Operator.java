package calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;

public enum Operator {
    PLUS("+", (a, b) -> a + b, Operator::noneValidation),

    MINUS("-", (a, b) -> a - b, Operator::noneValidation),

    DIVIDE("/", (a, b) -> a / b, Operator::divideValidation),

    MULTIPLY("*", (a, b) -> a * b, Operator::noneValidation);

    private final String code;
    private final BinaryOperator<Integer> binaryOperator;
    private final BiConsumer<Integer, Integer> validator;
    private final static Map<String, Operator> operatorMap = new HashMap<String, Operator>() {
        {
            for (Operator operator : Operator.values()) {
                put(operator.code, operator);
            }
        }
    };

    Operator(String code, BinaryOperator<Integer> binaryOperator, BiConsumer<Integer, Integer> validator) {
        this.code = code;
        this.binaryOperator = binaryOperator;
        this.validator = validator;
    }

    public Integer calculate(Integer a, Integer b) {
        validator.accept(a,b);
        return binaryOperator.apply(a, b);
    }

    public static Operator lookUp(String operatorCode) {
        Operator operator = operatorMap.get(operatorCode);
        if (operator == null) {
            throw new IllegalArgumentException("Abnormal operator");
        }

        return operator;
    }

    public static void noneValidation(Integer a, Integer b) {}

    private static void divideValidation(Integer left, Integer right) {
        if (right == 0) {
            throw new IllegalArgumentException("0으로 나눌수 없습니다");
        }
    }
}
