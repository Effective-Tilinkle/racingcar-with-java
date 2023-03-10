package domain.vo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FirstPlaceCarTest {

	@DisplayName("자동차가 추월했는지 확인한다")
	@ParameterizedTest
	@CsvSource({
			"1, false",
			"2, false",
			"3, false",
			"4, true",
	})
	void isPass(int position, boolean expected) {

		FirstPlaceCar firstPlaceCar = FirstPlaceCar.init();
		firstPlaceCar.changeFirstPlace(Car.of("pobi", 3));

		assertEquals(firstPlaceCar.isPass(position), expected);
	}

	@DisplayName("자동차가 따라잡았는지 확인한다")
	@ParameterizedTest
	@CsvSource({
			"1, false",
			"2, false",
			"3, true",
			"4, false",
	})
	void isOvertake(int position, boolean expected) {

		FirstPlaceCar firstPlaceCar = FirstPlaceCar.init();
		firstPlaceCar.changeFirstPlace(Car.of("pobi", 3));

		assertEquals(firstPlaceCar.isOvertake(position), expected);
	}
}