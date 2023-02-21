package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<Car> racingCars;

    public RacingCars(List<Car> racingCars) {
        this.racingCars = racingCars;
    }

    // 경주
    public void race(MoveConditionStrategy moveConditionStrategy) {
        racingCars.forEach(car -> car.move(moveConditionStrategy));
    }

    // 결과
    public List<Integer> getAllResultsOfMovementCount() {
        return racingCars.stream()
                .map(Car::getMovementCount)
                .collect(Collectors.toList());
    }
}
