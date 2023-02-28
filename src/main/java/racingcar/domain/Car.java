package racingcar.domain;

import java.util.concurrent.atomic.AtomicInteger;

public class Car {
    private final AtomicInteger movementCount = new AtomicInteger();

    public void move(MoveConditionStrategy moveConditionStrategy) {
        if (moveConditionStrategy.canMove()) {
            movementCount.incrementAndGet();
        }
    }

    public Integer getMovementCount() {
        return movementCount.get();
    }
}
