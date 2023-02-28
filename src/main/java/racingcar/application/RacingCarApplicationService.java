package racingcar.application;

import racingcar.domain.Car;
import racingcar.domain.MoveConditionStrategy;
import racingcar.domain.RacingCars;
import racingcar.domain.Round;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCarApplicationService {
    private final MoveConditionStrategy moveConditionStrategy;

    public RacingCarApplicationService(MoveConditionStrategy moveConditionStrategy) {
        this.moveConditionStrategy = moveConditionStrategy;
    }

    public List<RacingResult> raceAndGetAllResult(RaceCommand raceCommand) {
        List<Car> cars = createCars(raceCommand.getCarCount());
        Round round = new Round(raceCommand.getRoundCount());
        RacingCars racingCars = new RacingCars(cars);
        List<RacingResult> allRacingResults = new ArrayList<>();

        for (; round.hasNext(); round.next()) {
            racingCars.race(moveConditionStrategy);
            allRacingResults.add(racingCars.getRacingResult());
        }

        return Collections.unmodifiableList(allRacingResults);
    }

    private List<Car> createCars(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }

        return cars;
    }
}
