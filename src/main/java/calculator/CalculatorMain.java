package calculator;

import calculator.application.CalculationService;
import calculator.view.InputView;
import calculator.view.OutputView;
import domain.SimpleCalculator;

public class CalculatorMain {
    public static void main(String[] args) {
        CalculationService calculationService = new CalculationService(new SimpleCalculator());

        String input = InputView.getInputValue();
        OutputView.printResult(calculationService.calculate(input));
    }
}
