package racingcar.domain;

import racingcar.utils.Randoms;

public class CarMoveStrategy implements MoveStrategy {

    @Override
    public boolean movable() {
        int randomNumber = Randoms.pickNumberInRange(GameRules.START_RANGE.getValue(), GameRules.END_RANGE.getValue());
        return randomNumber >= GameRules.MOVABLE_STANDARD_VALUE.getValue();
    }
}
