package racingcar.domain;

public class Car {
    private int position;

    private Car() { }

    public static Car newInstance() {
        return new Car();
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.movable()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
