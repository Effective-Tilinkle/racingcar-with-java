import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import step2.StringCalculator;

public class StringCalculatorTest {

	@Test
	public void testCalculateExpression_ExampleOperators() {
		// Given
		String expression = "2 + 3 * 4 / 2";
		// When
		int result = StringCalculator.calculateExpression(expression);
		// Then
		Assertions.assertEquals(10, result);
	}

	@Test
	public void testCalculateExpression_MixedOperators() {
		// Given
		String expression = "10 + 5 * 2 - 8 / 2";
		// When
		int result = StringCalculator.calculateExpression(expression);
		// Then
		Assertions.assertEquals(11, result);
	}

	@Test
	public void testCalculateExpression_InvalidExpression() {
		// Given
		String expression = "10 +  + 5";
		// When & Then
		assertThatIllegalArgumentException()
				.isThrownBy(() -> StringCalculator.calculateExpression(expression))
				.withMessage("Invalid expression!");
	}

	@ParameterizedTest
	@ValueSource(strings = {"10 & 4 + 5"})
	void testCalculateExpression_InvalidExpression(String input) {
		// When & Then
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			StringCalculator.calculateExpression(input);
		});
	}

}