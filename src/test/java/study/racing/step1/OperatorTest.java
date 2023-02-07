package study.racing.step1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OperatorTest {
	@Test
	@DisplayName("연산자 생성 테스트")
	public void create_success() {
		assertThat(Operator.PLUS.equals(Operator.of("+"))).isTrue();
	}

	@Test
	@DisplayName("연산자 생성 실패 테스트")
	public void create_fail() {
		Assertions.assertThrows(RuntimeException.class, () -> Operator.of(""));
		Assertions.assertThrows(IllegalArgumentException.class, () -> Operator.valueOf(""));
	}
}
