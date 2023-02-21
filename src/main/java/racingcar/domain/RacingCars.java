package racingcar.domain;

import racingcar.application.RacingResult;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<Car> racingCars;

    public RacingCars(List<Car> racingCars) {
        if (racingCars.isEmpty()) {
            throw new IllegalArgumentException("레이싱에 참여할 자동차는 한대 이상이어야합니다.");
        }

        this.racingCars = racingCars;
    }

    // 경주
    public void race(MoveConditionStrategy moveConditionStrategy) {
        racingCars.forEach(car -> car.move(moveConditionStrategy));
    }

    // 결과
    public RacingResult getRacingResult() {
        return new RacingResult(
                        racingCars.stream()
                        .map(Car::getMovementCount)
                        .collect(Collectors.toList()));
    }
}
