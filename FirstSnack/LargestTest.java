import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LargestTest{
	@Test
	public void testIfThisCanGetLargestInt(){
	Largest large = new Largest();
	int[] array = {-20, -12, 14, 67, 29, 43};
	int result = large.largestNumber(array);	 
	assertEquals(67, result);
	int[] newArray = {89,45,76,38,48};
	int answer = large.largestNumber(newArray);
	assertEquals(89, answer);
	}

	@Test
	public void testIfThisCanGetSmallestInt(){
	Largest min = new Largest();
	int[] array = {34, 35, 75, 87, 44};
	int guy = min.minimumNumber(array);
	assertEquals(34, guy);
	}

}