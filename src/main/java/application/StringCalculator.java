package application;

import domain.Calculator;
import view.InputView;
import view.OutputView;

public class StringCalculator {
    public void calculate() {
        String input = InputView.inputValue();
        int result = new Calculator().getResult(input);
        OutputView.printResult(result);
    }
}
