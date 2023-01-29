package calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (a, b) -> a + b),

    MINUS("-", (a, b) -> a - b),

    DIVIDE("/", (a, b) -> a / b),

    MULTIPLY("*", (a, b) -> a * b);

    private final String code;
    private final BiFunction<Integer, Integer, Integer> calculationFunction;
    private final static Map<String, Operator> operatorMap = new HashMap<String, Operator>() {
        {
            for (Operator operator : Operator.values()) {
                put(operator.code, operator);
            }
        }
    };

    Operator(String code, BiFunction<Integer, Integer, Integer> calculationFunction) {
        this.code = code;
        this.calculationFunction = calculationFunction;
    }

    public Integer calculate(Integer a, Integer b) {
        return calculationFunction.apply(a, b);
    }

    public static Operator lookUp(String operatorCode) {
        Operator operator = operatorMap.get(operatorCode);
        if (operator == null) {
            throw new IllegalArgumentException("Abnormal operator");
        }

        return operator;
    }
}
