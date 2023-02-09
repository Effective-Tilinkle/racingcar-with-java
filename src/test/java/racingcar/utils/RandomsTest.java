package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.GameRules;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RandomsTest {
    @DisplayName("지정 범위에서 값이 잘 생성되는지 테스트")
    @Test
    public void 랜덤값은_0부터_9까지_생성된다() {
        int randomValue = Randoms.pickNumberInRange(GameRules.START_RANGE.getValue(), GameRules.END_RANGE.getValue());

        assertThat(randomValue).isLessThan(10);
    }

    @DisplayName("스택오버플로우가 생길 만큼 큰 입력이 들어온 경우 IllegalArgumentException이 발생한다.")
    @Test
    public void 끝_범위_최댓값_테스트() {
        assertThatThrownBy(() -> Randoms.pickNumberInRange(GameRules.START_RANGE.getValue(), Integer.MAX_VALUE))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("끝 범위가 너무 큽니다.");
    }

    @DisplayName("잘못된 범위가 입력된 경우 IllegalArgumentException이 발생한다.")
    @Test
    public void 잘못된_범위_입력_테스트() {
        assertThatThrownBy(() -> Randoms.pickNumberInRange(GameRules.END_RANGE.getValue(), GameRules.START_RANGE.getValue()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시작 범위는 끝 범위보다 클 수 없습니다.");
    }
}