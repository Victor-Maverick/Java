package myQueue;

import java.util.ArrayList;
import java.util.List;

public class MyQueue {
    private String[] queue = new String[10];
    private int tail = 0;
    public boolean add(String element) {
        if(tail == queue.length)throw new IllegalStateException("full");
        queue[tail] = element;
        tail++;

        return true;
    }


    public String remove() {
        String removed = queue[0];
        for(int index = 1; index< queue.length; index++){
            queue[index-1] = queue[index];
        }
        return removed;
    }

    public String poll() {
        if (isQueueEmpty()) return null;
        String removed = queue[0];
        remove();
        return removed;
    }

    private boolean isQueueEmpty() {
        int counter = 0;
        for(int count = 0; count < queue.length; count++){
            if(queue[count] == null) counter++;
        }
        if (counter == queue.length) return true;
        return false;
    }

    public String peek() {
        if (isQueueEmpty())return null;
        return queue[0];
    }
}
