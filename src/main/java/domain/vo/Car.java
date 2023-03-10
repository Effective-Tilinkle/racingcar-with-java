package domain.vo;

import utils.StringUtils;

public class Car {

	private String carName;
	private int position;

	private Car(String carName, int position) {
		this.carName = carName;
		this.position = position;
	}

	public static Car from(String carName) {
		return of(carName, 0);
	}

	public static Car of(String carName, int position) {
		validateCarName(carName);
		return new Car(carName, position);
	}

	public void move(boolean movable) {
		if (movable) {
			this.position++;
		}
	}

	public int getPosition() {
		return this.position;
	}

	public String getCarName() {
		return this.carName;
	}

	private static void validateCarName(String carName) {

		if (StringUtils.isEmpty(carName)) {
			throw new IllegalArgumentException("자동차 명이 입력 되지 않았습니다");
		}

		if (carName.length() > 5) {
			throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없다.");
		}
	}
}
