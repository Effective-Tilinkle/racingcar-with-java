package domain;

import domain.strategy.CarMoveStrategy;
import domain.strategy.WinnerStrategy;
import domain.vo.Cars;
import view.vo.RaceCondition;

public class CarRace {

	private final int tryCount;
	private int no = 1;
	private Cars cars;
	private final CarRaceDifficulty carRaceDifficulty;

	private CarRace(int tryCount, Cars cars, CarRaceDifficulty carRaceDifficulty) {
		this.tryCount = tryCount;
		this.cars = cars;
		this.carRaceDifficulty = carRaceDifficulty;
	}

	public static CarRace readyForRace(RaceCondition raceCondition, CarRaceDifficulty carRaceDifficulty) {
		return new CarRace(raceCondition.getTryCount(), Cars.from(raceCondition.getCarNames()), carRaceDifficulty);
	}

	public void race() {
		cars.move(CarMoveStrategy.from(carRaceDifficulty));
	}

	public Cars getCars() {
		return this.cars;
	}

	public String getWinners(WinnerStrategy winnerStrategy) {
		return winnerStrategy.winner();
	}

	public int getNo() {
		return this.no;
	}

	public int getTryCount() {
		return this.tryCount;
	}

	public void countNo() {
		this.no++;
	}

	public boolean isEnd() {
		return this.tryCount == this.no;
	}
}
