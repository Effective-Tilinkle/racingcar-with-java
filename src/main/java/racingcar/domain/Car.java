package racingcar.domain;

public class Car {
    private static final String NAME_LENGTH_EXCEPTION_MESSAGE = "이름은 5자 이하만 입력 가능합니다.";
    private static final String BLANK_CANNOT_ENTERED_NAME = "이름에 공백은 입력할 수 없습니다.";

    private String name;
    private int position;

    private Car(String name) {
        this.name = name;
    }

    public static Car from(String name) {
        validateCarName(name);
        return new Car(name);
    }

    public static void validateCarName(String name) {
        validateNameLength(name);
        validateInputBlank(name);
    }

    private static void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(NAME_LENGTH_EXCEPTION_MESSAGE);
        }
    }

    private static void validateInputBlank(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException(BLANK_CANNOT_ENTERED_NAME);
        }
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
