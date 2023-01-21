package domain;

import utils.StringUtils;

public class Calculator {
    public static final int FIRST_INDEX = 0;
    public static final int CALCULATION_UNIT_VALUE = 2;
    public static final String INPUT_VALUE_EMPTY = "입력 값이 비어 있습니다.";

    public int getResult(String input) {
        validate(input);
        return calculate(StringUtils.split(input));
    }

    private void validate(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException(INPUT_VALUE_EMPTY);
        }
    }

    private int calculate(String[] target) {
        int length = target.length;
        int initialValue = getFirstValue(target);

        return accumulateResult(length, initialValue, target);
    }

    private int accumulateResult(int length, int initialValue, String[] target) {
        int total = initialValue;

        for (int index = 2; index < length; index += CALCULATION_UNIT_VALUE) {
            total = Operator.operate(getSymbol(index, target), total, getSecondValue(index, target));
        }

        return total;
    }

    private int getFirstValue(String[] target) {
        return StringUtils.toInt(target[FIRST_INDEX]);
    }

    private int getSecondValue(int index, String[] target) {
        return StringUtils.toInt(target[index]);
    }

    private String getSymbol(int index, String[] target) {
        return target[index - 1];
    }

}
