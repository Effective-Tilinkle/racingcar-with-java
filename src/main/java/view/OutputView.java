package view;


import domain.CarRace;
import domain.strategy.CarRaceWinnerStrategy;
import domain.vo.Car;
import domain.vo.Cars;

public class OutputView {

	private OutputView(){}

	public static void print(CarRace carRace) {
		Cars cars = carRace.getCars();

		printStatus(carRace.getCars());

		if (carRace.isEnd()) {
			printWinner(carRace.getWinners(CarRaceWinnerStrategy.from(cars)));
		}
	}

	private static void printStatus(Cars cars) {
		StringBuilder racingStatusView = new StringBuilder();
		cars.stream()
			.forEach(car -> {
				racingStatusView.append(createCarRaceView(car));
			});

		System.out.println(racingStatusView);
	}

	private static void printWinner(String winner) {
		System.out.println(winner + "가 최종 우승");
	}

	private static String createCarRaceView(Car car) {

		StringBuilder view = new StringBuilder();

		return view.append(car.getCarName())
				   .append(" : ")
				   .append(convertPositionToView(car.getPosition()))
				   .append(System.lineSeparator())
				   .toString();
	}

	private static String convertPositionToView(int position) {
		StringBuilder positionView = new StringBuilder();
		for (int n = 0; n < position; n++) {
			positionView.append("-");
		}
		return positionView.toString();
	}
}
