package calculator;

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
}
