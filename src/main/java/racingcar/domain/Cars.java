package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Cars {
    private static final int MINIMUM_INPUT_OF_CAR_COUNT = 1;

    private List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(int carCount) {
        validate(carCount);
        return new Cars(createCars(carCount));
    }

    private static void validate(int carCount) {
        if (carCount < MINIMUM_INPUT_OF_CAR_COUNT) {
            throw new IllegalArgumentException("자동차는 1대 이상 입력되어야 합니다.");
        }
    }

    private static List<Car> createCars(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(Car.newInstance());
        }

        return cars;
    }

    public void moveCars(MoveStrategy moveStrategy) {
        for (Car car : cars) {
            car.move(moveStrategy);
        }
    }

    public Stream<Car> stream() {
        return cars.stream();
    }
}
