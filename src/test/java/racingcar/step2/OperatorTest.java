package racingcar.step2;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.step2.domain.Operand;
import racingcar.step2.domain.Operator;

public class OperatorTest {
	@Test
	@DisplayName("연산자 찾기")
	public void find_operator() {
		// given & when & then
		assertThat(Operator.of("+")).isEqualTo(Operator.PLUS);
		assertThat(Operator.of("-")).isEqualTo(Operator.MINUS);
		assertThat(Operator.of("/")).isEqualTo(Operator.DIVIDE);
		assertThat(Operator.of("*")).isEqualTo(Operator.MULTIPLE);
	}

	@Test
	@DisplayName("연산자 찾기 실패")
	public void not_find_operator() {
		// given & when & then
		Assertions.assertThrows(IllegalArgumentException.class, () -> Operator.of("//"));
		Assertions.assertThrows(IllegalArgumentException.class, () -> Operator.of("%"));
	}

	@Test
	@DisplayName("계산 테스트")
	public void calculate() {
		// given & when & then
		assertThat(Operator.of("+").operation(Operand.of("3"), Operand.of("3"))).isEqualTo(Operand.of("6"));
		assertThat(Operator.of("-").operation(Operand.of("3"), Operand.of("3"))).isEqualTo(Operand.of("0"));
		assertThat(Operator.of("/").operation(Operand.of("3"), Operand.of("3"))).isEqualTo(Operand.of("1"));
		assertThat(Operator.of("*").operation(Operand.of("3"), Operand.of("3"))).isEqualTo(Operand.of("9"));
	}
}
