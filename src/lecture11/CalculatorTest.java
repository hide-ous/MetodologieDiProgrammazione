package lecture11;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
	Calculator calc;
	@BeforeEach
	void setUp() {
		calc=new Calculator();
	}
	

	@Test
	void testMultiply() {
		
		int expected = 1*2;
		int returned = calc.multiply(1, 2);
		assertEquals(expected, returned);
		
	}

}
