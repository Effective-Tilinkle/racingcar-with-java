package racingcar.application;

public class RaceCommand {
    private final int carCount;
    private final int roundCount;

    public RaceCommand(int carCount, int roundCount) {
        validateCarCount(carCount);
        validateRoundCount(roundCount);

        this.carCount = carCount;
        this.roundCount = roundCount;
    }

    private void validateRoundCount(int roundCount) {
        if (roundCount < 1) {
            throw new IllegalArgumentException("라운드는 1회 이상이어야 합니다.");
        }
    }

    private void validateCarCount(int carCount) {
        if (carCount < 1) {
            throw new IllegalArgumentException("경주 하기위해 차는 1대 이상이어야 합니다.");
        }
    }

    public int getCarCount() {
        return carCount;
    }

    public int getRoundCount() {
        return roundCount;
    }
}
