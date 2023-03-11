package racingcar;

import racingcar.application.RaceCommand;
import racingcar.application.RacingCarApplicationService;
import racingcar.application.RacingResult;
import racingcar.domain.CarName;
import racingcar.domain.MoveConditionByRandomValue;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarMain {
    public static void main(String[] args) {
        String[] carNamesArray = InputView.getCarNames();
        int roundCount = InputView.getRoundCount();

        RacingCarApplicationService racingCarApplicationService = new RacingCarApplicationService(new MoveConditionByRandomValue());

        List<RacingResult> racingResults = racingCarApplicationService.raceAndGetAllResult(new RaceCommand(toCarNames(carNamesArray), roundCount));

        ResultView.printAllRacingResult(racingResults);
    }

    private static List<CarName> toCarNames(String[] carNamesArray) {
        return Arrays.stream(carNamesArray)
                .map(CarName::new)
                .collect(Collectors.toList());
    }
}
