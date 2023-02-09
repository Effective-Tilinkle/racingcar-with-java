package utils;

import java.util.Random;

public class Randoms {
    private static final Random RANDOM = new Random();

    private Randoms() { }

    public static int pickNumberInRange(final int startRange, final int endRange) {
        validateRange(startRange, endRange);
        return startRange + RANDOM.nextInt(endRange - startRange + 1);
    }

    private static void validateRange(final int startRange, final int endRange) {
        if (endRange == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("끝 범위가 너무 큽니다.");
        }

        if (startRange > endRange) {
            throw new IllegalArgumentException("시작 범위는 끝 범위보다 클 수 없습니다.");
        }
    }
}
