package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";
    private static final String INPUT_ROUND_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private static final String COMMA = ",";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() { }

    public static List<String> inputCarName() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        return convertToList(scanner.nextLine());
    }

    public static int inputRound() {
        System.out.println(INPUT_ROUND_MESSAGE);
        return scanner.nextInt();
    }

    private static List<String> convertToList(String inputNames) {
        List<String> names = new ArrayList<>();
        for (String name : inputNames.split(COMMA)) {
            names.add(name.trim());
        }

        return names;
    }
}
