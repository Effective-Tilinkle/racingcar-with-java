package racingcar.step2;

import racingcar.step2.domain.Calculator;
import racingcar.step2.view.InputView;
import racingcar.step2.view.ResultView;

public class CalculatorApplication {
	public static void main(String[] args) {
		ResultView.printCalculateStart();
		Calculator calculator = new Calculator(InputView.inputExpression(System.in));
		ResultView.printResult(calculator.calculate().getValue());
	}
}
