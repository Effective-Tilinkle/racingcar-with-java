package calculator.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorUtilsTest {

    @DisplayName("입력값이 공백을 기준으로 나누어져 배열로 생성된다.")
    @Test
    void 배열_생성_테스트() {
        assertThat(CalculatorUtils.split("2 + 3 * 4 / 2")).containsExactly("2", "+", "3", "*", "4", "/", "2");
    }

    @DisplayName("문자열이 숫자로 변환된다.")
    @Test
    void 숫자_변환_테스트() {
        assertThat(CalculatorUtils.toInt("2")).isEqualTo(2);
    }
}