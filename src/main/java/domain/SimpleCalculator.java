package domain;

public class SimpleCalculator implements Calculator<Integer> {
    public Integer calculate(String target) {
        validateTarget(target);

        String[] values = target.split(" ");
        int result = Integer.parseInt(values[0]);

        for (int i = 1; i < values.length; i += 2) {
            String operatorCode = values[i];
            int rightOperand = Integer.parseInt(values[i + 1]);

            result = doCalculate(operatorCode, result, rightOperand);
        }

        return result;
    }

    private static void validateTarget(String target) {
        if (target == null || target.trim().equals("")) {
            throw new IllegalArgumentException("Target must not null or not empty");
        }
    }

    private int doCalculate(String operator, int leftOperand, int rightOperand) {
        return Operator.lookUp(operator)
                .calculate(leftOperand, rightOperand);
    }
}
