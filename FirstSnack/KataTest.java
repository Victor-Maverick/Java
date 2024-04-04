import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class KataTest{

	@Test
	public void testReverseArray(){

	Kata kata = new Kata();

	int[] numbers = {1, 2, 3, 4, 5};
	int[] numbersInReverse = kata.reverse(numbers);
	//int[] expected = {5, 4, 3, 2, 1};
	//assertEquals(new int[]{5,4,3,2,1}, numbersInReverse);
	assertArrayEquals(new int[]{5,4,3,2,1}, numbersInReverse);
}

	

}