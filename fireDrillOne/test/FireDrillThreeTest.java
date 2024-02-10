import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class FireDrillThreeTest {
    private FireDrillThree fireDrillThree;

    @BeforeEach
    public void setup(){
        fireDrillThree = new FireDrillThree();
    }

    @Test
    public void testToCollectNumbersAndPrintArray(){
        int[] myArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] array = new int[10];
        assertArrayEquals(myArray, fireDrillThree.taskOne(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }

    @Test
    public void testToPrintArrayElementsOnAVerticalLine(){
        String myArray = "1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n";
        System.out.println(myArray);
        assertEquals(myArray, fireDrillThree.taskTwo(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }

    @Test
    public void testToPrintArrayElementsOnAHorizontalLine(){
        String myArray = "1 2 3 4 5 6 7 8 9 10 ";
        assertEquals(myArray, fireDrillThree.taskThree(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }

    @Test
    public void testToPrintOddArrayIndexElements(){
        int[] array = {1, 2, 3, 4, 5};
        int[] oddIndexArray = {2, 4};
        assertArrayEquals(oddIndexArray, fireDrillThree.taskFour(array));

    }

    @Test
    public void testToPrintEvenArrayIndexElements(){
        int[] array = {1, 2, 3, 4, 5};
        int[] oddIndexArray = {1, 3, 5};
        assertArrayEquals(oddIndexArray, fireDrillThree.taskFive(array));

    }

    @Test
    public void testToPrintSumOfOddArrayIndexElements(){
        int[] array = {1, 2, 3, 4, 5};
        int oddIndexSum = 6;
        assertEquals(oddIndexSum, fireDrillThree.taskSix(array));

    }

    @Test
    public void testToPrintSumOfEvenArrayIndexElements(){
        FireDrillThree fireDrillThree = new FireDrillThree();
        int[] array = {1, 2, 3, 4, 5};
        int evenIndexSum = 9;
        assertEquals(evenIndexSum, fireDrillThree.taskSeven(array));

    }

    @Test
    public void testForTheMinimumOfOddIndicesElementsInAnArray(){
        int[] array = {1, 2, 3, 4, 5, 1, 3, 7};
        int evenIndicesMinimum = 1;
        assertEquals(evenIndicesMinimum, fireDrillThree.taskEight(array));

    }

    @Test
    public void testForTheMinimumOfEvenIndicesElementsInAnArray(){
        int[] array = {9, 2, 3, 4, 5, 1, 3, 7};
        int evenIndicesMinimum = 3;
        assertEquals(evenIndicesMinimum, fireDrillThree.taskNine(array));

    }

    @Test
    public void testForTheMaximumOfOddIndicesElementsInAnArray(){
        FireDrillThree fireDrillThree = new FireDrillThree();
        int[] array = {1, 2, 3, 4, 5, 1, 3, 7};
        int oddIndicesMinimum = 7;
        assertEquals(oddIndicesMinimum, fireDrillThree.taskTen(array));

    }

    @Test
    public void testForTheMaximumOfEvenIndicesElementsInAnArray(){
        int[] array = {1, 2, 3, 4, 5, 1, 3, 7};
        int evenIndicesMinimum = 5;
        assertEquals(evenIndicesMinimum, fireDrillThree.taskEleven(array));

    }

    @Test
    public void swapElementsInOddIndicesWithElementsInEvenIndicesTest(){
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] swappedArray = {2, 1, 4, 3, 6, 5, 8, 7};
        assertArrayEquals(swappedArray, fireDrillThree.taskTwelve(array));
    }

    @Test
    public void checkIfAnyElementsIsEven_dontSwapTest(){
        int[] array = {1, 7, 4, 4, 5, 9, 6, 7, 8};
        int[] swappedArray = {7, 1, 4, 4, 9, 5, 6, 7, 8};
        assertArrayEquals(swappedArray, fireDrillThree.taskThirteen(array));
    }

    @Test
    public void checkIfAnyElementsIsOdd_dontSwapTest(){
        int[] array = {1, 7, 4, 2, 5, 9, 6, 7, 8};
        int[] swappedArray = {1, 7, 2, 4, 5, 9, 6, 7, 8};
        assertArrayEquals(swappedArray, fireDrillThree.taskFourteen(array));
    }

    @Test
    public void checkIfBothElementsAreOdd_dontSwapTest(){
        int[] array = {1, 7, 4, 2, 5, 9, 6, 7, 8};
        int[] swappedArray = {1, 7, 2, 4, 5, 9, 7, 6, 8};
        assertArrayEquals(swappedArray, fireDrillThree.taskFifteen(array));
    }

    @Test
    public void checkIfBothElementsAreEven_dontSwapTest(){
        int[] array = {1, 7, 4, 2, 5, 9, 6, 7, 8};
        int[] swappedArray = {7, 1, 4, 2, 9, 5, 7, 6, 8};
        assertArrayEquals(swappedArray, fireDrillThree.taskSixteen(array));
    }

}