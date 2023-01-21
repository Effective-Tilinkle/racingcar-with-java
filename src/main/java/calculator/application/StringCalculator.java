package calculator.application;

import calculator.domain.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class StringCalculator {
    public void calculate() {
        String input = InputView.inputValue();
        int result = new Calculator().getResult(input);
        OutputView.printResult(result);
    }
}
