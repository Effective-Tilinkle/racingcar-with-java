package calculator;

public class Calculator {
    public static int calculate(String target) {
        validateTarget(target);

        String[] sArr = target.split(" ");
        int res = Integer.parseInt(sArr[0]);

        for (int i = 1; i < sArr.length; i+=2) {
            String operator = sArr[i];
            int right = Integer.parseInt(sArr[i+1]);

            res = doCalculate(operator, res, right);
        }

        return res;
    }

    private static void validateTarget(String target) {
        if (target == null || target.trim().equals("")) {
            throw new IllegalArgumentException("target must not null or not empty");
        }
    }

    private static int doCalculate(String operator, int res, int right) {
        switch (operator) {
            case "*":
                res = multiply(res, right);
                break;
            case "+":
                res = plus(res, right);
                break;
            case "-":
                res = minus(res, right);
                break;
            case "/":
                res = divide(res, right);
                break;
            default:
                throw new IllegalArgumentException("abnormal operator");
        }

        return res;
    }

    private static int divide(int a, int b) {
        return a / b;
    }

    private static int minus(int a, int b) {
        return a - b;
    }

    private static int plus(int a, int b) {
        return a + b;
    }

    private static int multiply(int a, int b) {
        return a * b;
    }
}
