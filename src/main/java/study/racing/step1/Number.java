package study.racing.step1;

import java.util.Objects;

public class Number {

	private final Integer value;

	public static Number of(int value) {
		return new Number(Integer.valueOf(value));
	}

	public static Number of(Integer value) {
		return new Number(value);
	}

	private Number(Integer value) {
		this.value = value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Number number = (Number) o;
		return Objects.equals(value, number.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}
}
