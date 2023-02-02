package domain;

public class SimpleCalculator implements Calculator<Integer> {
    public Integer calculate(String target) {
        validateTarget(target);

        String[] sArr = target.split(" ");
        int result = Integer.parseInt(sArr[0]);

        for (int i = 1; i < sArr.length; i += 2) {
            String operatorCode = sArr[i];
            int right = Integer.parseInt(sArr[i + 1]);

            result = doCalculate(operatorCode, result, right);
        }

        return result;
    }

    private static void validateTarget(String target) {
        if (target == null || target.trim().equals("")) {
            throw new IllegalArgumentException("Target must not null or not empty");
        }
    }

    private int doCalculate(String operator, int left, int right) {
        return Operator.lookUp(operator)
                .calculate(left, right);
    }
}
