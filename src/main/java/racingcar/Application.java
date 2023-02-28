package racingcar;

import racingcar.application.RacingGame;
import racingcar.domain.CarMoveStrategy;

public class Application {
    public static void main(String[] args) {
        new RacingGame().play(new CarMoveStrategy());
    }
}
