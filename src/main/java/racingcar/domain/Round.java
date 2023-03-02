package racingcar.domain;

public class Round {
    private static final String ATTEMPT_COUNT_TOO_LARGE = "시도 회수가 너무 큽니다.";
    private static final String ATTEMPT_COUNT_CANNOT_BE_LESS_THAN_ZERO = "시도 회수는 0보다 작을 수 없습니다.";
    private static final int MINIMUM_INPUT_OF_ROUND = 0;

    private int attemptCount;

    private Round(int attemptCount) {
        this.attemptCount = attemptCount;
    }

    public static Round from(int attemptCount) {
        validateRound(attemptCount);
        return new Round(attemptCount);
    }

    private static void validateRound(int attemptCount) {
        if (attemptCount == Integer.MAX_VALUE) {
            throw new IllegalArgumentException(ATTEMPT_COUNT_TOO_LARGE);
        }

        if (attemptCount < MINIMUM_INPUT_OF_ROUND) {
            throw new IllegalArgumentException(ATTEMPT_COUNT_CANNOT_BE_LESS_THAN_ZERO);
        }
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}
