package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class Cars {
    private static final String CAR_NAME_CANNOT_DUPLICATE = "자동차 이름은 중복될 수 없습니다.";
    private static final String CAR_NAME_LEAST_ONE_MUST_ENTERED = "자동차는 1대 이상 입력되어야 합니다.";
    private static final int MINIMUM_INPUT_OF_CAR_COUNT = 1;

    private List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<String> carNames) {
        validate(carNames);
        return new Cars(createCars(carNames));
    }

    private static void validate(List<String> carNames) {
        if (carNames.size() < MINIMUM_INPUT_OF_CAR_COUNT) {
            throw new IllegalArgumentException(CAR_NAME_LEAST_ONE_MUST_ENTERED);
        }
    }

    private static List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = Car.from(carName);
            validateDuplicateCarName(cars, car);
            cars.add(car);
        }

        return cars;
    }

    private static void validateDuplicateCarName(List<Car> cars, Car car) {
        if (cars.contains(car)) {
            throw new IllegalArgumentException(CAR_NAME_CANNOT_DUPLICATE);
        }
    }

    public void moveCars(MoveStrategy moveStrategy) {
        for (Car car : cars) {
            car.move(moveStrategy);
        }
    }

    public String getWinners() {
        int topPosition = getTopPosition();
        return cars.stream()
                .filter(car -> car.isWinner(topPosition))
                .map(car -> car.getName())
                .collect(joining(", "));
    }

    private int getTopPosition() {
        int topPosition = Integer.MIN_VALUE;
        for (Car car : cars) {
            topPosition = Math.max(topPosition, car.getPosition());
        }
        return topPosition;
    }

    public Stream<Car> stream() {
        return cars.stream();
    }
}
