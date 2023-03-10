package domain.vo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import domain.CarRaceDifficulty;
import domain.strategy.CarMoveStrategy;
import domain.strategy.MoveStrategy;

class CarTest {

	@DisplayName("빈 자동차명을 입력하면 예외를 발생시킨다")
	@Test
	void validateEmptyNameTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			Car car = Car.from("");
		});
	}

	@DisplayName("자동차명이 5글자를 초과하면 예외를 발생시킨다")
	@Test
	void validateNameLengthOverTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			Car car = Car.from("abcdef");
		});
	}

	@DisplayName("자동차가 이동 가능한상태인 경우에만 이동한다")
	@RepeatedTest(5)
	@Test
	void movableTest() {

		MoveStrategy moveStrategy = CarMoveStrategy.from(CarRaceDifficulty.NORMAL);
		boolean movable = moveStrategy.movable();

		Car car = Car.from("abc");
		car.move(movable);

		if(movable) assertEquals(1, car.getPosition());
		if(!movable) assertEquals(0, car.getPosition());
	}
}