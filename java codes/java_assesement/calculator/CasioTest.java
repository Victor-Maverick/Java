import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CasioTest{
	@Test
	public void testThatCasioCanDividePositiveNumbers(){
	Casio casio = new Casio();
	int dividend = casio.divide(50, 5);
	assertEquals(10, dividend);
	}

	@Test
	public void testThatCasioCanSubtractPositiveNumbers(){
	Casio cas = new Casio();
	int difference = cas.subtract(50, 10);
	assertEquals(40, difference);
	}
}