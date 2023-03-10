package domain.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import domain.vo.Car;
import domain.vo.Cars;

class CarRaceWinnerStrategyTest {

	@DisplayName("3개 자동차 기준으로, 각 이동한 위치에 따라, 우승 자동차를 확인한다")
	@ParameterizedTest
	@MethodSource("carArgumentProvider")
	void winnerTest(Car pobiCar, Car crongCar, Car honuxCar, String expected) {

		Cars cars = Cars.from(Arrays.asList(pobiCar, crongCar, honuxCar));

		WinnerStrategy winnerStrategy = CarRaceWinnerStrategy.from(cars);

		assertEquals(expected, winnerStrategy.winner());
	}


	private static Stream<Arguments> carArgumentProvider() {
		return Stream.of(createArguments(1, 2, 3, "honux"),
						 createArguments(1, 3, 3, "crong,honux"),
						 createArguments(3, 3, 3, "pobi,crong,honux"));
	}

	private static Arguments createArguments(int pobiPos, int crongPos, int honuxPos, String expected) {
		return Arguments.of(Car.of("pobi", pobiPos),
							Car.of("crong", crongPos),
							Car.of("honux", honuxPos),
							expected);
	}
}