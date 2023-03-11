package racingcar.application;

import racingcar.domain.CarName;

import java.util.List;

public class RaceCommand {
    private final List<CarName> carNames;
    private final int roundCount;

    public RaceCommand(List<CarName> carNames, int roundCount) {
        validateCarNames(carNames);
        validateRoundCount(roundCount);

        this.carNames = carNames;
        this.roundCount = roundCount;
    }

    private void validateRoundCount(int roundCount) {
        if (roundCount < 1) {
            throw new IllegalArgumentException("라운드는 1회 이상이어야 합니다.");
        }
    }

    private void validateCarNames(List<CarName> carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException("경주 하기위해 차는 1대 이상이어야 합니다.");
        }
    }

    public List<CarName> getCarNames() {
        return carNames;
    }

    public int getRoundCount() {
        return roundCount;
    }
}
