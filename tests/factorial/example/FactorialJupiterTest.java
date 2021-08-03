package factorial.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class FactorialJupiterTest {
	
	private Factorial factorial;

	@BeforeEach
	void setup() {
		factorial = new Factorial();
	}
	
	@ParameterizedTest
	@CsvSource({
		"0, 1",
		"1, 1",
		"2, 2",
		"3, 6",
		"4, 24"
	})
	void testFactorial(int input, int expected) {
		assertThat(factorial.compute(input)).isEqualTo(expected);
	}
	
	@Test
	void testFactorialNegativeInput() {
		assertThatThrownBy(()->factorial.compute(-1))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("Negative input: -1");
	}

}
