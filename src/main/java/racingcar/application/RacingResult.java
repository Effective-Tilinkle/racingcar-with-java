package racingcar.application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingResult {
    private final List<Integer> carMovementCounts;

    public RacingResult(List<Integer> carMovementCounts) {
        this.carMovementCounts = Collections.unmodifiableList(new ArrayList<>(carMovementCounts));
    }

    public List<Integer> getCarMovementCounts() {
        return carMovementCounts;
    }
}
