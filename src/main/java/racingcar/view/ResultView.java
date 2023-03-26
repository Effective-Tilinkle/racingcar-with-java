package racingcar.view;

import racingcar.domain.Cars;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

public class ResultView {
    private static final String HYPHEN = "-";
    private static final String RACING_RESULT = "%s : %s";
    private static final String WINNER_MESSAGE = "%s가 최종 우승했습니다.";

    private ResultView() { }

    public static void printRacingResult(Cars cars) {
        cars.stream()
                .forEach(car -> System.out.println(
                        String.format(
                                RACING_RESULT,
                                car.getName(),
                                printHyphen(car.getPosition()))
                        )
                );
        System.out.println();
    }

    private static String printHyphen(int position) {
        return IntStream.rangeClosed(1, position)
                .mapToObj(moveCount -> HYPHEN)
                .collect(joining(""));
    }

    public static void printWinner(Cars cars) {
        System.out.println(
                String.format(
                        WINNER_MESSAGE,
                        cars.getWinners()
                )
        );
    }
}
