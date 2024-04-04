import myPackage.Practice;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PracticeTest {
    @Test
    public void ifSumIsEqualOrGreaterThanFirstInputTest(){
        Practice practice = new Practice();
        assertTrue(practice.checkSumOfNumbers(30, 5, 3, 2, 3, 10, 10));
    }


}