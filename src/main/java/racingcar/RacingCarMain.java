package racingcar;

import racingcar.application.RaceCommand;
import racingcar.application.RacingCarApplicationService;
import racingcar.application.RacingResult;
import racingcar.domain.MoveConditionByRandomValue;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingCarMain {
    public static void main(String[] args) {
        int carCount = InputView.getCarCount();
        int roundCount = InputView.getRoundCount();

        RacingCarApplicationService racingCarApplicationService = new RacingCarApplicationService(new MoveConditionByRandomValue());
        List<RacingResult> racingResults = racingCarApplicationService.raceAndGetAllResult(new RaceCommand(carCount, roundCount));

        ResultView.printAllRacingResult(racingResults);
    }
}
