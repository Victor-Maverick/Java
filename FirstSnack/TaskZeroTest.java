import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TaskZeroTest{
	@Test
	public void testAndSquareArrayElements(){
	TaskZero task = new TaskZero();
	int[] array = {-2, 4, 5, 7, 10};
	int[] newArray = {4, 16, 25, 49, 100};
	int[] emptyArray = task.squareElelments(array);
	
	assertArrayEquals(newArray, emptyArray);
	}

}