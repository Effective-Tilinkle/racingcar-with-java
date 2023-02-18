package racingcar.domain;

import racingcar.view.ResultView;

public class Racing {
    private Round round;

    public Racing(Round round) {
        this.round = round;
    }

    public void start(Cars cars, MoveStrategy moveStrategy) {
        for (int i = 0; i < round.getAttemptCount(); i++) {
            cars.moveCars(moveStrategy);
            ResultView.printRacingResult(cars);
        }
    }

}
