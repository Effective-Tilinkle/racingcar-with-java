package racingcar.domain;

import java.util.Random;

public class Car {
    private int position;

    private Car() { }

    public static Car init() {
        return new Car();
    }

    public void move() {
        Random random = new Random();
        int randomNumber = random.nextInt(GameRules.START_RANGE.getValue());
        if (randomNumber >= GameRules.MOVABLE_STANDARD_VALUE.getValue()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
