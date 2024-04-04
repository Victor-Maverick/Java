import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ElementTest{

	@Test
	public void testIfIntElementOccursInList(){
	Element element = new Element();
	int[] array = {32, 43, 23, 75, 67};
	int number = 23;
	boolean answer = element.findElement(array, number);
	assertTrue(answer);
	}

	@Test
	public void testIfStringElementOccursInList(){
	Element element = new Element();
	String[] newArray = {"bag", "pen", "school", "light", "laptop"};
	String item = "bag";
	boolean expected = element.findStringElement(newArray, item);
	assertTrue(expected);
	}

}