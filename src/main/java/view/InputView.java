package view;


import java.util.Scanner;

public class InputView {

	private String carNames;
	private int tryCount;

	private static Scanner input = new Scanner(System.in);

	private InputView(String carNames, int tryCount) {
		this.carNames = carNames;
		this.tryCount = tryCount;
	}

	public String getCarNames() {
		return carNames;
	}

	public int getTryCount() {
		return tryCount;
	}

	public static InputView start() {
		String carNames = inputCarName();
		int tryCount = inputRaceTryCount();
		return new InputView(carNames, tryCount);
	}

	private static String inputCarName() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		return input.nextLine();
	}

	private static int inputRaceTryCount() {
		System.out.println("시도할 회수는 몇 회 인가요?");
		return input.nextInt();
	}
}
