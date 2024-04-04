import java.util.ArrayList;

public class MySet {
    private int noOfElements;
    private ArrayList<Object> elements;
    private boolean isEmpty = true;


    public MySet(){
        elements = new ArrayList<>();
        noOfElements = 0;
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public boolean contains(Object element){
        return elements.contains(element);
    }

    public void add(Object element) {
        if(!elements.contains(element)) elements.add(element);
        noOfElements++;
    }

    public void remove(Object element) {
        if(noOfElements == 0)throw new IllegalArgumentException("empty");
        elements.remove(element);
        noOfElements--;
    }

    public int size() {
        return elements.size();
    }
}
