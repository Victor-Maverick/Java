import mindfort.MyStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.EmptyStackException;
import static org.junit.jupiter.api.Assertions.*;


public class MyStackTest {
    private MyStack myStack;

    @BeforeEach
    public void setup(){
        myStack = new MyStack(3);
    }

    @Test
    public void newStackIsEmptyTest(){
        assertTrue(myStack.empty());
    }

    @Test
    public void addItemToStack_stackIsNotEmptyTest(){

        assertTrue(myStack.empty());
        myStack.push(2);
        assertFalse(myStack.empty());

    }

    @Test
    public void addItem_RemoveItem_stackIsEmptyTest(){
        assertTrue(myStack.empty());
        myStack.push(4);
        assertFalse(myStack.empty());

    }

    @Test
    public void addThreeItems_popOnce_stackIsNotEmptyTest(){
        assertTrue(myStack.empty());
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        assertFalse(myStack.empty());
        myStack.pop();
        assertFalse(myStack.empty());
    }

    @Test
    public void popItemFromEmptyStack_throwExceptionTest(){
        assertTrue(myStack.empty());
        assertThrows(IllegalArgumentException.class, () -> myStack.pop());
    }

    @Test
    public void addItemOntoFullStack_stackOverFlowError(){
        assertTrue(myStack.empty());
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        assertFalse(myStack.empty());
        assertThrows(StackOverflowError.class, ()-> myStack.push(5));
    }

    @Test
    public void addThreeElementsOntoStack_returnLastElementAddedTest(){
        assertTrue(myStack.empty());
        myStack.push(2);
        myStack.push("vic");
        myStack.push(4);
        assertEquals(4, myStack.peek());
    }


    @Test
    public void peekFromEmptyStack_throwExceptionTest(){
        assertTrue(myStack.empty());
        assertThrows(EmptyStackException.class, ()-> myStack.peek());
    }

    @Test
    public void addThreeElementsOntoStack_searchForAParticularElement_returnsPositionTest(){
        assertTrue(myStack.empty());
        myStack.push(5);
        myStack.push(7);
        myStack.push(8);
        assertEquals(1, myStack.search(5));
    }

    @Test
    public void addThreeElementsOntoStack_searchForANonExistingElement_returnsMinusOneTest(){
        assertTrue(myStack.empty());
        myStack.push(5);
        myStack.push(7);
        myStack.push(8);
        assertEquals(-1, myStack.search(9));
    }

    @Test
    public void searchEmptyStack_throwExceptionTest(){
        assertTrue(myStack.empty());
        assertThrows(EmptyStackException.class, ()-> myStack.search(2));
    }

}
