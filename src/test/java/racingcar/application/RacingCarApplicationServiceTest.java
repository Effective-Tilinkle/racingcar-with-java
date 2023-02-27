package racingcar.application;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;
import racingcar.domain.MoveConditionStrategy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarApplicationServiceTest {
    private MoveConditionStrategy alwaysTrueMoveCondition = () -> true;
    private RacingCarApplicationService racingCarApplicationService = new RacingCarApplicationService(alwaysTrueMoveCondition);
    private int carCount = 3;
    private int roundCount = 5;


    @Test
    void 항상_움직이는_조건인_레이싱() {
        // given
        RaceCommand raceCommand = new RaceCommand(carCount, roundCount);

        // when
        List<RacingResult> racingResults = racingCarApplicationService.raceAndGetAllResult(raceCommand);

        // then
        assertThat(racingResults)
                .hasSize(roundCount);
        for (int i = 0; i < roundCount; i++) {
            int moveCount = i + 1;
            assertThat(racingResults)
                    .satisfies(racingResult ->
                        assertThat(racingResult.getCarMovementCounts())
                                .hasSize(carCount)
                                .allMatch(carMoveCount -> carMoveCount == moveCount)
                    , Index.atIndex(i));
        }
    }

    @Test
    void round가_1보다_작으면_에러() {
        roundCount = -1;
        assertThatThrownBy(() -> new RaceCommand(carCount, roundCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("라운드는 1회 이상이어야 합니다.");
    }

    @Test
    void car가_1보다_작으면_에러() {
        carCount = -1;
        assertThatThrownBy(() -> new RaceCommand(carCount, roundCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("경주 하기위해 차는 1대 이상이어야 합니다.");
    }

}