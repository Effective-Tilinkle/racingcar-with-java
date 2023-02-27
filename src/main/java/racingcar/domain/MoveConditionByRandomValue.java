package racingcar.domain;

import java.util.Random;

public class MoveConditionByRandomValue implements MoveConditionStrategy {
    private static final Random random = new Random();
    private static final int MOVE_CRITERIA = 4;
    private static final int MAX_RANDOM_NUMBER = 9;

    @Override
    public boolean canMove() {
        return random.nextInt(MAX_RANDOM_NUMBER + 1) >= MOVE_CRITERIA;
    }
}
