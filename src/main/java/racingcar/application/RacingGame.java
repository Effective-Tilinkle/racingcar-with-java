package racingcar.application;

import racingcar.domain.Cars;
import racingcar.domain.Racing;
import racingcar.domain.Round;
import racingcar.view.InputView;

public class RacingGame {
    public void play() {
        Cars cars = Cars.from(InputView.inputCarCount());
        Round round = Round.from(InputView.inputRound());
        Racing racing = new Racing(round);
        racing.start(cars);
    }
}
