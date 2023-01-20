package calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Calculator {
    public static int calculate(String target) {
        validateTarget(target);

        String[] sArr = target.split(" ");
        int res = Integer.parseInt(sArr[0]);

        for (int i = 1; i < sArr.length; i += 2) {
            String operatorCode = sArr[i];
            int right = Integer.parseInt(sArr[i + 1]);

            res = doCalculate(operatorCode, res, right);
        }

        return res;
    }

    private static void validateTarget(String target) {
        if (target == null || target.trim().equals("")) {
            throw new IllegalArgumentException("Target must not null or not empty");
        }
    }

    private static int doCalculate(String operator, int res, int right) {
        return Operator.lookUp(operator)
                .calculate(res, right);
    }

    enum Operator {

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
}
