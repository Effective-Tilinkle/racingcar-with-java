package calculator;

import domain.Calculator;
import domain.SimpleCalculator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleCalculatorTest {

    Calculator calculator = new SimpleCalculator();

    @Test
    void 계산_정상() {
        // given
        String target = "2 + 3 * 4 / 2";

        // when
        // then
        assertEquals(10, calculator.calculate(target));
    }

    @Test
    void 계산_실패_null_또는_빈값() {
        // given
        String target = null;

        // when
        // then
        assertThatThrownBy(() -> calculator.calculate(target))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Target must not null or not empty");
    }

    @Test
    void 계산_실패_연산자이상() {
        // given
        String target = "2 + 3 * 4 | 2";

        // when
        // then
        assertThatThrownBy(() -> calculator.calculate(target))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Abnormal operator");
    }

    @Test
    void 나눗셈_0으로_나누면_안된다() {
        // given
        String target = "2 + 3 * 4 / 0";

        // when
        // then
        assertThatThrownBy(() -> calculator.calculate(target))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0으로 나눌수 없습니다");

    }
}