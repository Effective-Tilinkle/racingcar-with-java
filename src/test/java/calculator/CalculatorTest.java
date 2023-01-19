package calculator;

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
        assertEquals("target must not null or not empty", illegalArgumentException.getMessage());
    }

    @Test
    void 계산_실패_연산자이상() {
        // given
        String target = "2 + 3 * 4 | 2";

        // when
        // then
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> Calculator.calculate(target));
        assertEquals("abnormal operator", illegalArgumentException.getMessage());
    }
}