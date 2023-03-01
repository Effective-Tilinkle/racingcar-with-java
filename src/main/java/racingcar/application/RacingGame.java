package racingcar.application;

import racingcar.domain.Cars;
import racingcar.domain.MoveStrategy;
import racingcar.domain.Racing;
import racingcar.domain.Round;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGame {
    public void play(MoveStrategy moveStrategy) {
        Cars cars = Cars.from(InputView.inputCarName());
        Round round = Round.from(InputView.inputRound());
        Racing racing = new Racing(round);
        racing.start(cars, moveStrategy);
        ResultView.printWinner(cars);
    }
}
