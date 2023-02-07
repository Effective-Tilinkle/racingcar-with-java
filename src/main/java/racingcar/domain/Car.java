package racingcar.domain;

import utils.Randoms;

public class Car {
    private int position;

    private Car() { }

    public static Car init() {
        return new Car();
    }

    public void move() {
        int randomNumber = Randoms.pickNumberInRange(GameRules.START_RANGE.getValue(), GameRules.END_RANGE.getValue());
        if (randomNumber >= GameRules.MOVABLE_STANDARD_VALUE.getValue()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
