package racingcar.view;

import racingcar.domain.Cars;

public class ResultView {
    private static final String HYPHEN = "-";

    private ResultView() { }

    public static void printRacingResult(Cars cars) {
        cars.stream()
                .forEach(car -> System.out.println(printHyphen(car.getPosition())));
        System.out.println();
    }

    private static String printHyphen(int position) {
        StringBuilder hyphen = new StringBuilder();
        for (int i = 0; i < position; i++) {
            hyphen.append(HYPHEN);
        }

        return hyphen.toString();
    }
}
