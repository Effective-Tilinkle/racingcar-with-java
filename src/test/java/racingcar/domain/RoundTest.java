package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RoundTest {

    @DisplayName("너무 큰 시도 횟수가 입력된 경우 IllegalArgumentException이 발생한다.")
    @Test
    void 시도_횟수_최댓값_테스트() {
        assertThatThrownBy(() -> Round.from(Integer.MAX_VALUE))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 회수가 너무 큽니다.");
    }

    @DisplayName("잘못된 시도 횟수 범위가 입력된 경우 IllegalArgumentException이 발생한다.")
    @ValueSource(ints = { 0, -1 })
    void 잘못된_범위_시도_횟수_입력_테스트(int inputRound) {
        assertThatThrownBy(() -> Round.from(inputRound))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 회수는 0보다 작을 수 없습니다.");
    }
}