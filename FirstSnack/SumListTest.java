import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SumListTest{
	
	@Test
	public void testForIntSumListWithForLoop(){
	SumList sumList = new SumList();
	int[] array = {30, 20, 50, 100};
	int result = sumList.forLoopSum(array);
	assertEquals(200, result);
	}


	@Test
	public void testForIntSumWithWhileLoop(){
	SumList sumList = new SumList();
	int[] newArray = {50, 40, 60, 30, 20};
	int outcome = sumList.whileLoopSum(newArray);
	assertEquals(200, outcome);
	}	

	@Test
	public void testForIntSumWithDowhileLoop(){
	SumList sumList = new SumList();
	int[] arrays = {22, 33, 55, 11, 98};
	int number = sumList.doWhileSum(arrays);
	assertEquals(219, number);
	}

}