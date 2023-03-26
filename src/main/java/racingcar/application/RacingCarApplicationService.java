package racingcar.application;

import racingcar.domain.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCarApplicationService {
    private final MoveConditionStrategy moveConditionStrategy;

    public RacingCarApplicationService(MoveConditionStrategy moveConditionStrategy) {
        this.moveConditionStrategy = moveConditionStrategy;
    }

    public List<RacingResult> raceAndGetAllResult(RaceCommand raceCommand) {
        List<Car> cars = createCars(raceCommand.getCarNames());
        Round round = new Round(raceCommand.getRoundCount());
        RacingCars racingCars = new RacingCars(cars);
        List<RacingResult> allRacingResults = new ArrayList<>();

        for (; round.hasNext(); round.next()) {
            racingCars.race(moveConditionStrategy);
            allRacingResults.add(racingCars.getRacingResult());
        }

        return Collections.unmodifiableList(allRacingResults);
    }

    private List<Car> createCars(List<CarName> carNames) {
        List<Car> cars = new ArrayList<>();
        for (CarName carName : carNames) {
            cars.add(new Car(carName));
        }

        return cars;
    }
}
