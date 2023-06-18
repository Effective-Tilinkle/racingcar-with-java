package racingcar.step2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.step2.domain.Calculator;
import racingcar.step2.domain.Operand;

public class CalculatorTest {
	@Test
	@DisplayName("정상적인 계산 테스트")
	public void calculate() {
		// given
		Calculator calculator = new Calculator("3 / 3 * 1 + 1");
		// when
		Operand calculate = calculator.calculate();
		// then
		assertThat(calculate.getValue()).isEqualTo(2);
	}

	@Test
	@DisplayName("유효하지 않은 계산식 생성 테스트")
	public void invalid_create() {
		// given & when & then
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Calculator("3 /"));
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Calculator("3 + 1 +"));
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Calculator("3 * 2 -"));
	}

	@Test
	@DisplayName("연산자, 피연산자 올바르지 않는 순서일 경우 계산 실패 테스트")
	public void invalid_calculate() {
		// given & when & then
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Calculator("3 / /").calculate());
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Calculator("3 + 1 1").calculate());
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Calculator("3 * 2 - -").calculate());
	}
}
