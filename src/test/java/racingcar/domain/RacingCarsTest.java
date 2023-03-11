package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarsTest {
    MoveConditionStrategy alwaysMoveStrategy = () -> true;

    @Test
    void 승자이름가져오기() {
        // given
        CarName winnerName = new CarName("jh");
        Car jh = new Car(winnerName);
        jh.move(alwaysMoveStrategy);
        jh.move(alwaysMoveStrategy);

        Car hm = new Car(new CarName("hm"));
        hm.move(alwaysMoveStrategy);
        Car son = new Car(new CarName("son"));
        son.move(alwaysMoveStrategy);

        RacingCars racingCars = new RacingCars(Arrays.asList(jh, hm, son));

        // when
        List<CarName> winnerCarNames = racingCars.getRacingResult().getWinnerCarNames();

        // then
        assertThat(winnerCarNames)
                .hasSize(1)
                .first()
                .isEqualTo(winnerName);

    }

}