package racingcar.application;

import racingcar.domain.Cars;
import racingcar.domain.Racing;
import racingcar.view.InputView;

public class RacingGame {
    public void play() {
        Cars cars = Cars.from(InputView.inputCarCount());
        Racing racing = Racing.from(InputView.inputRound());
        racing.start(cars);
    }
}
