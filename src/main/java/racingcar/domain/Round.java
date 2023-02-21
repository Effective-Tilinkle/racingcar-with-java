package racingcar.domain;

public class Round {
    private int currentRound;
    private final int maxRound;

    public Round(int maxRound) {
        if (maxRound < 1) {
            throw new IllegalArgumentException("총 round는 1보다 커야합니다.");
        }

        this.currentRound = 1;
        this.maxRound = maxRound;
    }

    public boolean hasNext() {
        return maxRound >= currentRound;
    }
    public void next() {
        currentRound++;
    }
}
