package mindfort;
import java.util.EmptyStackException;

public class MyStack {

    private Object[] elements = new Object[5];
    private int noOfElements = 0;
    private int size;

    public MyStack(int size){
        this.size =  size;

    }

    public boolean empty() {
        if(noOfElements == 0)return true;
        return false;
    }

    public void push(Object element) {
        if(noOfElements == size)throw new StackOverflowError("overflow");
        elements[noOfElements] = element;
        noOfElements++;
    }

    public void pop() {
        if(noOfElements == 0)throw new IllegalArgumentException("Cannot pop empty stack");
        Object[] newElements = new Object[elements.length - 1];

        for (int index = 0; index < newElements.length; index++) newElements[index] = elements[index];

        elements = newElements;
        noOfElements--;
    }

    public Object peek() {
        if(noOfElements == 0)throw new EmptyStackException();
        return elements[noOfElements-1];

    }

    public int search(Object element) {
        if(noOfElements == 0)throw new EmptyStackException();

        for(int index = 0; index < elements.length; index++) if (element == elements[index]) return index + 1;


        return  -1;
    }

}
