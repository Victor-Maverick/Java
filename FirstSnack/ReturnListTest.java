import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReturnListTest{


	@Test
	public void testAndReturnDigitAsAnArray(){
	ReturnList returnList = new ReturnList();
	int myNumber = 3456;
	int[] myArray = returnList.listElements(myNumber);
	int[] array = {3, 4, 5, 6};
	assertArrayEquals(array, myArray);
	}
}