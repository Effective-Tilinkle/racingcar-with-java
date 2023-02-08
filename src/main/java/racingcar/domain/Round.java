package racingcar.domain;

public class Round {
    private int round;

    private Round(int round) {
        this.round = round;
    }

    public static Round from(int round) {
        validateRound(round);
        return new Round(round);
    }

    private static void validateRound(int round) {
        if (round == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("시도 회수가 너무 큽니다.");
        }

        if (round < 0) {
            throw new IllegalArgumentException("시도 회수는 0보다 작을 수 없습니다.");
        }
    }

    public int getRound() {
        return round;
    }
}
