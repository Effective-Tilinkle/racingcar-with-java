package racingcar.step2.domain;

@FunctionalInterface
public interface OperatorProcess {
	Operand process(Operand num1, Operand num2);
}
