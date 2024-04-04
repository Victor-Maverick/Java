import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OddPositionsTest{
	@Test
	public void testForElementsInOddPossitions(){
	OddPositions oddPositions = new OddPositions();
	int[] array = {1, 2, 3, 4, 5, 7, 8, 9};
	int[] elements = oddPositions.positionElements(array);
	int[] oddElements = {1, 3, 5, 8};
	assertArrayEquals(oddElements, elements);	

	}	


}