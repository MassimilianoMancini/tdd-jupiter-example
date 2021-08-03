package string.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MyStringUtilsJupiterTest {
	
	private MyStringUtils myStringUtils;
	
	@BeforeEach
	void setup() {
		myStringUtils = new MyStringUtils();
	}

	@ParameterizedTest(name = "{index}: ''{0}'' => ''{1}''")
	@CsvSource({
		",",
		"'', ''",
		"' abc', abc",
		"abc, abc",
		"'\tabc', abc",
		"'  abc', abc",
		"'  ', ''",
		"'\t abc', abc"
	})
	void testLeftTrim(String input, String expected) {
		assertThat(myStringUtils.leftTrim(input)).isEqualTo(expected);
	}

}
