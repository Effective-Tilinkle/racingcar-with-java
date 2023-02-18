package racingcar.domain;

import racingcar.view.ResultView;

public class Racing {
    private Round round;

    public Racing(Round round) {
        this.round = round;
    }

    public void start(Cars cars) {
        for (int i = 0; i < round.getAttemptCount(); i++) {
            cars.moveCars();
            ResultView.printRacingResult(cars);
        }
    }

}
