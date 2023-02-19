package racingcar.step2.domain;

import java.util.Objects;

public class Operand {
	private static final String INVALID_OPERAND_MESSAGE = "올바르지 않은 피연산자 입니다.";
	private static final String DIVIDED_ZERO_MESSAGE = "0 으로 나눌 수 없습니다.";
	private final Integer value;

	private Operand(Integer value) {
		this.value = value;
	}

	public static Operand of(String input) {
		try {
			return new Operand(Integer.parseInt(input));
		} catch (NumberFormatException e){
			throw new IllegalArgumentException(INVALID_OPERAND_MESSAGE);
		}
	}

	public Operand plus(Operand operand) {
		return new Operand(value + operand.value);
	}

	public Operand minus(Operand operand) {
		return new Operand(value - operand.value);
	}

	public Operand multiple(Operand operand) {
		return new Operand(value * operand.value);
	}

	public Operand divide(Operand operand) {
		if (operand.value == 0)
			throw new IllegalArgumentException(DIVIDED_ZERO_MESSAGE);
		return new Operand(value / operand.value);
	}

	public Integer getValue() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Operand operand = (Operand) o;
		return Objects.equals(value, operand.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}
}
