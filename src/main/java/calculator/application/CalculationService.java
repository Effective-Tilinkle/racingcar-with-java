package calculator.application;

import domain.Calculator;

public class CalculationService {
    private final Calculator calculator;

    public CalculationService(Calculator calculator) {
        this.calculator = calculator;
    }

    public Object calculate(String target) {
        return calculator.calculate(target);
    }
}
