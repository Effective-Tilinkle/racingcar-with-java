package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarsTest {

    @DisplayName("레이싱 참가 차량이 1대 미만으로 입력된 경우 IllegalArgumentException이 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = { 0, -1 })
    void 차량_입력_개수_유효성_테스트(int carCount) {
        assertThatIllegalArgumentException().isThrownBy(() -> Cars.from(carCount));
    }

    @DisplayName("입력한 값 만큼 Cars 객체가 생성된다.")
    @ParameterizedTest
    @CsvSource(value = {
            "4 : 4",
            "5 : 5",
            "2 : 2",
            "3 : 3"}, delimiter = ':')
    void 자동차_그룹_생성_테스트(int carCount, int carsSize) {
        Cars cars = Cars.from(carCount);
        assertThat(cars.stream().count()).isEqualTo(carsSize);
    }
}