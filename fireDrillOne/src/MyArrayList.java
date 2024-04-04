
public class MyArrayList {

    private String[] names = new String[3];
    private int noOfElements = 0;

    public boolean isEmpty() {

        return noOfElements == 0;

    }

    public void add(String goods) {
        names[noOfElements] = goods;
        noOfElements++;
    }

    public void remove(String goods) {
        if(noOfElements == 0) throw new ArrayIndexOutOfBoundsException ("empty");
        noOfElements--;
    }

    public void remove(int indexOfElements) {
        String[] newArray = new String[names.length - 1];
        int count = 0;
        for(int index = 0; index < names.length; index++){
            if (index == indexOfElements)continue;
            newArray[count] = names[index];
            count++;
        }
        names = newArray;
    }
    public int getLengthOfArray(){
        return names.length;
    }

    public void insert(String element, int index) {
        if(index >= names.length)throw new ArrayIndexOutOfBoundsException("Add instead");

        names[index-1] = element;
    }
    public String get(int i) {
        return String.format(names[i-1]);
    }

    public int size() {
        return noOfElements;
    }
    public void clear() {
        noOfElements = 0;
    }
}
