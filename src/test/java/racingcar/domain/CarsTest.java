package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarsTest {

    @DisplayName("레이싱 참가 차량이 1대 미만으로 입력된 경우 IllegalArgumentException이 발생한다.")
    @ParameterizedTest
    @MethodSource("emptyCarNameProvider")
    void 차량_입력_개수_유효성_테스트(List<String> carNames) {
        assertThatIllegalArgumentException().isThrownBy(() -> Cars.from(carNames));
    }

    private static Stream<Arguments> emptyCarNameProvider() {
        return Stream.of(
                Arguments.of(Arrays.asList("")),
                Arguments.of(Arrays.asList("", "")),
                Arguments.of(Collections.emptyList())
        );
    }

    @DisplayName("입력한 값 만큼 Cars 객체가 생성된다.")
    @ParameterizedTest
    @MethodSource("carNamesAndSizeProvider")
    void 자동차_그룹_생성_테스트(List<String> carNames, int expectCarsSize) {
        Cars cars = Cars.from(carNames);
        assertThat(cars.stream().count()).isEqualTo(expectCarsSize);
    }

    private static Stream<Arguments> carNamesAndSizeProvider() {
        return Stream.of(
                Arguments.of(Arrays.asList("차1"), 1),
                Arguments.of(Arrays.asList("차1","차2"), 2),
                Arguments.of(Arrays.asList("차1","차2","차3"), 3),
                Arguments.of(Arrays.asList("차1","차2","차3","차4"), 4)
        );
    }

    @DisplayName("중복된 자동차 이름이 입력된 경우 IllegalArgumentException이 발생한다.")
    @ParameterizedTest
    @MethodSource("duplicateCarNamesProvider")
    void 중복된_자동차_이름_예외_테스트(List<String> carNames) {
        assertThatIllegalArgumentException().isThrownBy(() -> Cars.from(carNames));
    }

    private static Stream<Arguments> duplicateCarNamesProvider() {
        return Stream.of(
                Arguments.of(Arrays.asList("차1","차1")),
                Arguments.of(Arrays.asList("차1","차2","차1")),
                Arguments.of(Arrays.asList("차3","차2","차3","차2")),
                Arguments.of(Arrays.asList("pobi","pobi","crong"))
        );
    }

    @DisplayName("올바른 우승자를 찾아 반환한다.")
    @ParameterizedTest
    @MethodSource("carNamesAndWinnerProvider")
    void 우승자_반환_테스트(List<String> carNames, String winners) {
        Cars cars = Cars.from(carNames);
        boolean toggle = true;

        for (Car car : cars.getCars()) {
            car.move(switchMoveStrategy(toggle));
            toggle = !toggle;
        }

        assertThat(cars.getWinners()).isEqualTo(winners);
    }

    private MoveStrategy switchMoveStrategy(boolean toggle) {
        MoveStrategy alwaysMoveStrategy = () -> true;
        MoveStrategy alwaysStopStrategy = () -> false;

        if (toggle) {
            return alwaysMoveStrategy;
        }

        return alwaysStopStrategy;
    }

    private static Stream<Arguments> carNamesAndWinnerProvider() {
        return Stream.of(
                Arguments.of(Arrays.asList("차1"), "차1"),
                Arguments.of(Arrays.asList("차1","차2"), "차1"),
                Arguments.of(Arrays.asList("차1","차2","차3"), "차1, 차3"),
                Arguments.of(Arrays.asList("차1","차2","차3","차4"), "차1, 차3")
        );
    }
}