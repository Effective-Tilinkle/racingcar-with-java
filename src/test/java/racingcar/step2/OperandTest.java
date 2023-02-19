package racingcar.step2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.step2.domain.Operand;

public class OperandTest {
	@Test
	@DisplayName("생성 테스트")
	public void create() {
		// given & when & then
		assertThat(Operand.of("1").getValue()).isEqualTo(1);
		assertThat(Operand.of("2").getValue()).isEqualTo(2);
		assertThat(Operand.of("3").getValue()).isEqualTo(3);
	}

	@Test
	@DisplayName("유효하지 않는 문자열 테스트")
	public void invalid_create() {
		// given & when & then
		Assertions.assertThrows(IllegalArgumentException.class, () -> Operand.of("//"));
		Assertions.assertThrows(IllegalArgumentException.class, () -> Operand.of("+"));
		Assertions.assertThrows(IllegalArgumentException.class, () -> Operand.of("하이동동"));
	}

	@Test
	@DisplayName("연산 테스트 - 1")
	public void process() {
		// given
		Operand leftOperand = Operand.of("2");
		Operand rightOperand = Operand.of("3");

		// when & then
		assertThat(leftOperand.plus(rightOperand).getValue()).isEqualTo(5);
		assertThat(leftOperand.minus(rightOperand).getValue()).isEqualTo(-1);
		assertThat(leftOperand.divide(rightOperand).getValue()).isEqualTo(0);
		assertThat(leftOperand.multiple(rightOperand).getValue()).isEqualTo(6);
	}

	@Test
	@DisplayName("연산 테스트 - 2")
	public void process2() {
		// given
		Operand leftOperand = Operand.of("5");
		Operand rightOperand = Operand.of("3");

		// when & then
		assertThat(leftOperand.plus(rightOperand).getValue()).isEqualTo(8);
		assertThat(leftOperand.minus(rightOperand).getValue()).isEqualTo(2);
		assertThat(leftOperand.divide(rightOperand).getValue()).isEqualTo(1);
		assertThat(leftOperand.multiple(rightOperand).getValue()).isEqualTo(15);
	}

	@Test
	@DisplayName("0으로 나누기 실패 테스트")
	public void divided_by_zero() {
		// given & when & then
		Assertions.assertThrows(IllegalArgumentException.class, () -> Operand.of("3").divide(Operand.of("0")));
		Assertions.assertThrows(IllegalArgumentException.class, () -> Operand.of("5").divide(Operand.of("0")));
	}
}
