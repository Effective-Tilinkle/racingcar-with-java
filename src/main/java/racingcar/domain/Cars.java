package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Cars {
    private List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(int carCount) {
        return new Cars(createCars(carCount));
    }

    private static List<Car> createCars(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(Car.init());
        }

        return cars;
    }

    public void moveCars() {
        MoveStrategy moveStrategy = new CarMoveStrategy();
        for (Car car : cars) {
            car.move(moveStrategy);
        }
    }

    public Stream<Car> stream() {
        return cars.stream();
    }
}
