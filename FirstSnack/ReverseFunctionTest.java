import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseFunctionTest{
	@Test
	public void testIfArrayCanBeReversed(){
	Reverse reverse = new Reverse();
	int[] array1 =  {23, 43, 54, 78, 34};
	int[] secondArray = {34, 78, 54, 43, 23};
	int[] reversedArray = reverse.reverseArray(array1);
	assertEquals(secondArray, reversedArray);
	}


}