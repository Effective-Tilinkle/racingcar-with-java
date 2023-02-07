package study.racing.step1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberTest {

	@Test
	@DisplayName("숫자 생성 테스트")
	public void create() {
		assertThat(Number.of(2).equals(Number.of(2))).isTrue();
		assertThat(Number.of(2).equals(Number.of(Integer.valueOf(2)))).isTrue();
		assertThat(Number.of(2).equals(Number.of(3))).isFalse();
		assertThat(Number.of(2).equals(Number.of(Integer.valueOf(3)))).isFalse();
	}
}
