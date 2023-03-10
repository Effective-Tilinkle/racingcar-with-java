package view.vo;

import view.InputView;

public class RaceCondition {

	private final String carNames;
	private final int tryCount;

	private RaceCondition(String carNames, int tryCount) {
		this.carNames = carNames;
		this.tryCount = tryCount;
	}

	public static RaceCondition from(InputView view) {
		validate(view.getCarNames(), view.getTryCount());
		return new RaceCondition(view.getCarNames(), view.getTryCount());
	}

	public static RaceCondition of(String carNames, int tryCount) {
		validate(carNames, tryCount);
		return new RaceCondition(carNames, tryCount);
	}

	private static void validate(String carNames, int tryCount) {
		if (carNames.isEmpty()) {
			throw new IllegalArgumentException("잘못된 자동차 이름 입력");
		}
		if (tryCount < 1) {
			throw new IllegalArgumentException("잘못된 시도 횟수 입력");
		}
	}

	public String getCarNames() {
		return carNames;
	}

	public int getTryCount() {
		return tryCount;
	}
}
