package domain.strategy;

import domain.vo.Car;
import domain.vo.Cars;

import java.util.ArrayList;
import java.util.List;

public class CarRaceWinnerStrategy implements WinnerStrategy {

    private Cars cars;
    private List<Car> winners = new ArrayList<>();

    private CarRaceWinnerStrategy(Cars cars) {
        this.cars = cars;
    }

    public static CarRaceWinnerStrategy from(Cars cars) {
        return new CarRaceWinnerStrategy(cars);
    }

    @Override
    public String winner() {
        decideWinner();
        return winnerToString();
    }


    private String winnerToString() {
        StringBuilder sb = new StringBuilder();
        for (Car winner : winners) {
            sb.append(winner.getCarName()).append(",");
        }

        return sb.deleteCharAt(sb.length() - 1).toString();
    }


    private void decideWinner() {

        Car firstPlaceCar = cars.sortByPosition().findFirst().get();
        winners.add(firstPlaceCar);

        cars.sortByPosition()
                .skip(1)
                .forEach(car -> {
                    addWinner(firstPlaceCar, car);
                });

    }

    private void addWinner(Car firstPlaceCar, Car car) {
        if (car.getPosition() == firstPlaceCar.getPosition())
            winners.add(car);
    }
}
