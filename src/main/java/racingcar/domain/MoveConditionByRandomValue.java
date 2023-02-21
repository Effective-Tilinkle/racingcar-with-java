package racingcar.domain;

import java.util.Random;

public class MoveConditionByRandomValue implements MoveConditionStrategy {
    private final Random random = new Random();
    private static final int moveCriteria = 4;

    @Override
    public boolean canMove() {
        return random.nextInt(10) >= moveCriteria;
    }
}
