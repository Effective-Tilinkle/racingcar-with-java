package calculator.domain;

import calculator.utils.CalculatorUtils;

public class StringCalculator {
    private static final int FIRST_INDEX = 0;
    private static final int CALCULATION_UNIT_VALUE = 2;

    private StringCalculator() { }

    public static int getResult(String input) {
        return calculate(CalculatorUtils.split(input));
    }

    private static int calculate(String[] target) {
        int length = target.length;
        int initialValue = getFirstValue(target);

        return accumulateResult(length, initialValue, target);
    }

    private static int accumulateResult(int length, int initialValue, String[] target) {
        int totalValue = initialValue;

        for (int index = 2; index < length; index += CALCULATION_UNIT_VALUE) {
            totalValue = Operator.operate(totalValue, getOperationSymbol(index, target), getSecondValue(index, target));
        }

        return totalValue;
    }

    private static int getFirstValue(String[] target) {
        return CalculatorUtils.toInt(target[FIRST_INDEX]);
    }

    private static int getSecondValue(int index, String[] target) {
        return CalculatorUtils.toInt(target[index]);
    }

    private static String getOperationSymbol(int index, String[] target) {
        int symbolIndex = index - 1;
        return target[symbolIndex];
    }

}
