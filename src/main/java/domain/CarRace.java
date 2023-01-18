package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;

import domain.vo.Car;

public class CarRace implements Race<Stream<Car>> {

	private List<Car> cars = new ArrayList<>();
	private final CarRaceDifficulty carRaceDifficulty;
	private Map<Integer, Stream<Car>> carRaceStatus = new HashMap<>();

	public static CarRace readyForRace(int carCount, CarRaceDifficulty carRaceDifficulty) {
		List<Car> newCars = createNewRacingCar(carCount);
		return new CarRace(newCars, carRaceDifficulty);
	}

	private CarRace(List<Car> cars, CarRaceDifficulty carRaceDifficulty) {
		this.cars = cars;
		this.carRaceDifficulty = carRaceDifficulty;
	}

	private static List<Car> createNewRacingCar(int carCount) {
		List<Car> newCars = new ArrayList<>();
		for (int cnt = 0; cnt < carCount; cnt++) {
			newCars.add(new Car("", 0));
		}
		return newCars;
	}

	@Override
	public void race(int tryNo) {
		cars.forEach(car -> {
			move(car);
		});

		carRaceStatus.put(tryNo, cars.stream());
	}

	private void move(Car car) {
		Random random = new Random();
		if (carRaceDifficulty.isMoveOk(random.nextInt(10))) {
			car.move();
		}
	}

	@Override
	public Stream<Car> getRaceStatus(int tryNo) {
		return this.carRaceStatus.get(tryNo);
	}
}
