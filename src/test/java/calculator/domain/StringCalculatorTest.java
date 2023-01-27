package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StringCalculatorTest {

    @DisplayName("공백이 입력된 경우 IllegalArgumentException이 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {" ", ""})
    void 입력값은_공백이_아니어야한다(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new StringCalculator().getResult(input))
                .withMessage("입력 값이 비어 있습니다.");
    }

    @DisplayName("계산할 수 없는 형태의 입력값이 들어온 경우 IllegalArgumentException이 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "2 + 6 ++ 2 / 8",
            "2 + 3 * 4/ 2",
            "2 + 3 ** 4",
            "20 // 3 * 4 - 2" })
    void 올바르지_않은_입력값_테스트(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new StringCalculator().getResult(input));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1000 + 20000 : 21000",
            "200 - 100 : 100",
            "20 / 5 : 4",
            "30 * 3 : 90",
            "2 + 6 * 2 / 8 : 2",
            "2 + 3 * 4 / 2 : 10",
            "20 / 3 * 4 - 2 : 22", }, delimiter = ':')
    void 사칙연산_테스트(final String input, final int result) {
        assertThat(new StringCalculator().getResult(input)).isEqualTo(result);
    }

    @DisplayName("완전한 형태의 수식만 계산식에 포함된다.")
    @ParameterizedTest
    @CsvSource(value = {
            "20 / 5 + : 4",
            "30 * 3 - : 90",
            "2 + 6 * 2 / 8 + : 2",
            "2 + 3 * 4 / 2 / : 10",
            "20 / 3 * 4 - 2 * : 22", }, delimiter = ':')
    void 계산식_구성_테스트(final String input, final int result) {
        assertThat(new StringCalculator().getResult(input)).isEqualTo(result);
    }
}