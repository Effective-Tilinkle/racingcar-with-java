package domain.strategy;

import java.util.Random;

import domain.CarRaceDifficulty;

public class CarMoveStrategy implements MoveStrategy {

	private CarRaceDifficulty carRaceDifficulty;

	private CarMoveStrategy(CarRaceDifficulty carRaceDifficulty) {
		this.carRaceDifficulty = carRaceDifficulty;
	}

	public static CarMoveStrategy from(CarRaceDifficulty carRaceDifficulty) {
		return new CarMoveStrategy(carRaceDifficulty);
	}

	@Override
	public boolean movable() {

		Random random = new Random();
		int randomValue = random.nextInt(carRaceDifficulty.getRandomRange());

		return movable(randomValue);
	}

	public boolean movable(int randomValue) {
		int moveCondition = carRaceDifficulty.getMoveCondition();
		return moveCondition <= randomValue;
	}

}
