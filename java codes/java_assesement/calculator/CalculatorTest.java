import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest{


	@Test
	public void testThatCalculatorCanAddTwoPositiveNumbers(){
		//1.Given
		Calculator calculator = new Calculator();
		//2. when
		int sum = calculator.add(5, 6);
		//3. check
		assertEquals(11, sum);
		//takes two arguments,expected,actual and must be of same type

	}
	@Test
	public void testThatCalculatorCanMultiplyTwoPositiveNumbers(){
		Calculator calc = new Calculator();
		int product = calc.multiply(5, 6);
		assertEquals(30, product);
	}

	@Test
	public void testThatCalculatorCanAddNegativeNumbers(){
		Calculator calculator = new Calculator();
		int sum = calculator.add(-3, -2);
		
		System.out.println("sum: "+sum);
		assertEquals(-5, sum);
	}

	@Test
	public void testThatCalculatorCanMuliply(){
		Calculator calculator = new Calculator();
		int product = calculator.multiply(3,5);
	}
}