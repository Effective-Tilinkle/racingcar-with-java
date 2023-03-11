package racingcar.view;

import racingcar.application.RacingResult;
import racingcar.domain.CarName;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String MOVE_VIEW = "-";

    private ResultView() {}

    public static void printAllRacingResult(List<RacingResult> racingResults) {
        System.out.println("실행결과");
        for (RacingResult racingResult : racingResults) {
            printRacingResult(racingResult.getResults());
            System.out.println();
        }

        printFinalWinner(racingResults.get(racingResults.size() - 1).getWinnerCarNames());
    }

    private static void printFinalWinner(List<CarName> winnerCarNames) {
        String winner = winnerCarNames.stream()
                .map(CarName::getName)
                .collect(Collectors.joining(", "));
        System.out.println(winner+"가 최종 우승했습니다.");
    }

    private static void printRacingResult(List<RacingResult.Result> results) {
        results.forEach(result -> {
            System.out.printf(result.getCarName().getName()+ " : ");
            for (int i = 0; i < result.getCarMovementCounts(); i++) {
                System.out.printf(MOVE_VIEW);
            }
            System.out.println();
        });
    }
}
