package application.service;

import domain.CarRace;
import domain.CarRaceDifficulty;
import view.InputView;
import view.OutputView;
import view.vo.RaceCondition;

public class CarRaceService {

	public static void main(String[] args) {

		InputView view = InputView.start();
		RaceCondition raceCondition = RaceCondition.from(view);

		CarRace race = CarRace.readyForRace(raceCondition, CarRaceDifficulty.NORMAL);

		while (race.getNo() <= race.getTryCount()) {
			race.race();
			OutputView.print(race);
			race.countNo();
		}
	}
}
