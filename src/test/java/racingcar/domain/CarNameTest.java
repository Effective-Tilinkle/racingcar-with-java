package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarNameTest {
    @Test
    void 자동차_이름은_5자_초과_불가() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarName("abcdef"))
                .withMessage("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @Test
    void 자동차_이름은_5자_이내로() {
        assertThatNoException()
                .isThrownBy(() -> new CarName("abcde"));

    }
}