package racingcar.domain;

import java.util.List;

public class RacingCars {
    private final List<Car> racingCars;

    public RacingCars(List<Car> racingCars) {
        this.racingCars = racingCars;
    }

    // 경주
    public void race(MoveConditionStrategy moveConditionStrategy) {

    }

    // 기록
    public void record() {

    }
}
