package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = Car.from("car1");
    }

    @Nested
    @DisplayName("자동차 객체는")
    class DescribeCar {

        @Test
        @DisplayName("movable 값이 true 라면 1칸 전진하고")
        void 자동차_전진_테스트() {
            MoveStrategy movable = () -> true;
            car.move(movable);

            assertThat(car.getPosition()).isOne();
        }

        @Test
        @DisplayName("movable 값이 false 라면 이동하지 않는다.")
        void 자동차_정지_테스트() {
            MoveStrategy movable = () -> false;
            car.move(movable);

            assertThat(car.getPosition()).isZero();
        }
    }

    @DisplayName("값이 4이상일때만 1칸 전진한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "4 : 1",
            "5 : 1",
            "6 : 1",
            "7 : 1",
            "2 : 0",
            "3 : 0"}, delimiter = ':')
    void 자동차_전진_규칙_테스트(int moveNumber, int expectPosition) {
        TestMoveStrategy moveStrategy = new TestMoveStrategy();
        moveStrategy.movable(moveNumber);
        car.move(moveStrategy);

        assertThat(car.getPosition()).isEqualTo(expectPosition);
    }

    @DisplayName("자동차 이름이 같은 경우 같은 Car 객체로 판단된다.")
    @Test
    void 객체_동치_테스트() {
        Car car2 = Car.from("car1");
        assertThat(car).isEqualTo(car2)
                .hasSameHashCodeAs(car2);
    }
}