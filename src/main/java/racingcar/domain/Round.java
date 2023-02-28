package racingcar.domain;

public class Round {
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
            throw new IllegalArgumentException("시도 회수가 너무 큽니다.");
        }

        if (attemptCount < 0) {
            throw new IllegalArgumentException("시도 회수는 0보다 작을 수 없습니다.");
        }
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}
