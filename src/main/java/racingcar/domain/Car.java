package racingcar.domain;

import java.util.concurrent.atomic.AtomicInteger;

public class Car {
    private final CarName carName;
    private final AtomicInteger movementCount = new AtomicInteger();

    public Car(CarName carName) {
        this.carName = carName;
    }

    public void move(MoveConditionStrategy moveConditionStrategy) {
        if (moveConditionStrategy.canMove()) {
            movementCount.incrementAndGet();
        }
    }

    public Integer getMovementCount() {
        return movementCount.get();
    }

    public CarName getCarName() {
        return carName;
    }
}
