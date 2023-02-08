package racingcar.domain;

public enum GameRules {
    START_RANGE(0),
    END_RANGE(9),
    MOVABLE_STANDARD_VALUE(4);

    private final int value;

    GameRules(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
