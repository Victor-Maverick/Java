import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EvenPositionsTest{
	
	@Test
	public void testForElementsInEvenPositionsAndDisplay(){
	EvenPositions evenPositions = new EvenPositions();
	int[] myArray = {1, 2, 3, 4, 5, 6, 100, 9, 10};
	int[] actual = evenPositions.evenElementsPositions(myArray);
	int[] array = {2, 4, 6, 9};
	assertArrayEquals(array, actual);
	}
	
}