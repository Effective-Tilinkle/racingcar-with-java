package racingcar.domain;

public class TestMoveStrategy implements MoveStrategy {
    private int number;

    @Override
    public boolean moveAble() {
        return moveAble(number);
    }

    public boolean moveAble(int number) {
        this.number = number;
        return number >= 4;
    }
}
