package calculator.application;

import calculator.domain.StringCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Calculator {
    public void calculate() {
        String input = InputView.inputValue();
        int result = StringCalculator.getResult(input);
        OutputView.printResult(result);
    }
}
