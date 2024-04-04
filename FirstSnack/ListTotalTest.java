import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListTotalTest{

	@Test
	public void testForTheTotalInAnIntArray(){
	ListTotal list = new ListTotal();
	int[] myArray = {90, 50, 60, 70, 20};
	int result = list.listTotal(myArray);
	assertEquals(290, result);
	}
}