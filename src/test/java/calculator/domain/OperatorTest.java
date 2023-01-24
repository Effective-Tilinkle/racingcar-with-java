package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperatorTest {

    @DisplayName("지정한 사칙연산 기호가 아닌 경우 IllegalArgumentException이 발생한다.")
    @ParameterizedTest
    @MethodSource("invalidOperatorProvider")
    void 유효하지_않은_연산자_테스트(int firstValue, String symbol, int secondValue) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Operator.operate(firstValue, symbol, secondValue))
                .withMessage("사칙 연산 기호가 아닙니다. 입력값을 확인해주세요.");
    }

    private static Stream<Arguments> invalidOperatorProvider() {
        return Stream.of(
                Arguments.of(1, "$", 2),
                Arguments.of(2, "!",3),
                Arguments.of(2, "~", 3),
                Arguments.of(2, "#", 3)
        );
    }

    @DisplayName("0으로 나누었을 경우 ArithmeticException이 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "0 : 7",
            "10 : 0",
            "0 : 0"}, delimiter = ':')
    void 모든값은_0으로_나눌수_없다(int firstValue, int secondValue) {
        assertThatThrownBy(() -> Operator.operate(firstValue, "/", secondValue))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("0으로 나눌 수 없습니다.");
    }
}