package racingcar.view;

import racingcar.application.RacingResult;

import java.util.List;

public class ResultView {
    private static final String MOVE_VIEW = "-";

    private ResultView() {}

    public static void printAllRacingResult(List<RacingResult> racingResults) {
        System.out.println("실행결과");
        for (RacingResult racingResult : racingResults) {
            printRacingResult(racingResult.getCarMovementCounts());
            System.out.println();
        }
    }

    private static void printRacingResult(List<Integer> carMovementCounts) {
        carMovementCounts.forEach(moveCount -> {
            for (int i = 0; i < moveCount; i++) {
                System.out.printf(MOVE_VIEW);
            }
            System.out.println();
        });

    }
}
