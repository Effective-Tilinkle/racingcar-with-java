package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    @Test
    void 계산_정상() {
        // given
        String target = "2 + 3 * 4 / 2";

        // when
        // then
        assertEquals(10, Calculator.calculate(target));
    }

    @Test
    void 계산_실패_null_또는_빈값() {
        // given
        String target = null;

        // when
        // then
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> Calculator.calculate(target));
        assertEquals("Target must not null or not empty", illegalArgumentException.getMessage());
    }

    @Test
    void 계산_실패_연산자이상() {
        // given
        String target = "2 + 3 * 4 | 2";

        // when
        // then
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> Calculator.calculate(target));
        assertEquals("Abnormal operator", illegalArgumentException.getMessage());
    }

    @Test
    void 나눗셈_0으로_나누면_안된다() {
        // given
        String target = "2 + 3 * 4 / 0";

        // when
        // then
        Assertions.assertThatThrownBy(() -> Calculator.calculate(target))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0으로 나눌수 없습니다");

    }
}