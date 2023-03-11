package racingcar.application;

import racingcar.domain.CarName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingResult {
    private final List<Result> results;

    public RacingResult(List<Result> results) {
        this.results = Collections.unmodifiableList(new ArrayList<>(results));
    }

    public List<Result> getResults() {
        return results;
    }

    public static final class Result {
        private final int carMovementCounts;
        private final CarName carName;

        public Result(int carMovementCounts, CarName carName) {
            this.carMovementCounts = carMovementCounts;
            this.carName = carName;
        }

        public int getCarMovementCounts() {
            return carMovementCounts;
        }

        public CarName getCarName() {
            return carName;
        }
    }
}
