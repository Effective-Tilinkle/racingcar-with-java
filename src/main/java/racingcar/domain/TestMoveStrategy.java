package racingcar.domain;

public class TestMoveStrategy implements MoveStrategy {
    private int number;

    @Override
    public boolean movable() {
        return movable(number);
    }

    public boolean movable(int number) {
        this.number = number;
        return number >= 4;
    }
}
