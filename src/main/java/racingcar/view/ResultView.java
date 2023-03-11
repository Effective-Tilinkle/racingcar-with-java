package racingcar.view;

import racingcar.application.RacingResult;

import java.util.List;

public class ResultView {
    private static final String MOVE_VIEW = "-";

    private ResultView() {}

    public static void printAllRacingResult(List<RacingResult> racingResults) {
        System.out.println("실행결과");
        for (RacingResult racingResult : racingResults) {
            printRacingResult(racingResult.getResults());
            System.out.println();
        }
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
