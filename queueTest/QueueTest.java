package queueTest;

import myQueue.IllegalStateException;
import myQueue.MyQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class QueueTest {
    private MyQueue myQueue;

    @BeforeEach
    public void setUp(){
        myQueue = new MyQueue();
    }

    @Test
    public void addElementToQueue_returnsTrueTest(){
        assertEquals(true, myQueue.add("item"));
    }

    @Test
    public void addElementsToQueue_removeElement_returnsAndRemovesHeadOfQueueTest(){
        myQueue.add("item");
        myQueue.add("another item");
        assertEquals("item", myQueue.remove());
    }

    @Test
    public void elementsToQueue_pollElement_returnsAndRemovesHeadOFQueueTest(){
        myQueue.add("item");
        myQueue.add("another item");
        assertEquals("item", myQueue.poll());
    }

    @Test
    public void pollElementFromEmptyQueue_returnsNullTest(){
        assertEquals(null, myQueue.poll());
    }

    @Test
    public void addElementsToQueue_peek_returnsHeadOfQueueTest(){
        myQueue.add("item");
        myQueue.add("another item");
        assertEquals("item", myQueue.peek());
    }

    @Test
    public void peekElementFromEmptyQueue_returnsNullTest(){
        assertEquals(null, myQueue.peek());
    }

    @Test
    public void addElementsBeyondCapacity_throwsIllegalStateExceptionTest(){
        for(int count = 1; count <= 10; count++){myQueue.add("item");}
        assertThrows(IllegalStateException.class, ()-> myQueue.add("new item"));
    }

}
