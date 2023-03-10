package domain.vo;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

	@DisplayName("자동차 명 입력 값에 따라 유효성 검증을 하는지 확인한다")
	@Test
	void validateNameTest(){
		assertThrows(IllegalArgumentException.class, () -> {
			Cars cars = Cars.from("");
		});
	}
}