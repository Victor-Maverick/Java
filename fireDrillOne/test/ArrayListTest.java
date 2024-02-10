import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {
    private MyArrayList arrayList;

    @BeforeEach
    public void startAllWith(){
        arrayList = new MyArrayList();
    }

    @Test
    public void arrayListIsEmptyOnCreation(){
        assertTrue(arrayList.isEmpty());
    }

    @Test
    public void addElementToList_listIsNotEmptyTest(){
        assertTrue(arrayList.isEmpty());
        arrayList.add("goods");
        assertFalse(arrayList.isEmpty());
    }

    @Test
    public void addNewElement_removeNewElement_listIsEmptyTest(){
        assertTrue(arrayList.isEmpty());
        arrayList.add("goods");
        assertFalse(arrayList.isEmpty());
        arrayList.remove("goods");
        assertTrue(arrayList.isEmpty());
    }

    @Test
    public void addTwoElements_removeOneElement_listIsNotEmptyTest(){
        assertTrue(arrayList.isEmpty());
        arrayList.add("goods");
        assertFalse(arrayList.isEmpty());
        arrayList.add("books");
        arrayList.remove("goods");
        assertFalse(arrayList.isEmpty());

    }

    @Test
    public void removeElementFromEmptyList_throwException(){
        assertTrue(arrayList.isEmpty());
        assertThrows(ArrayIndexOutOfBoundsException.class, ()-> arrayList.remove("goods"));

    }

    @Test
    public void addThreeElements_removeElementSecondElement_index_ChangesTest(){
        assertTrue(arrayList.isEmpty());
        arrayList.add("goods");
        assertFalse(arrayList.isEmpty());
        arrayList.add("books");
        arrayList.add("computers");
        arrayList.remove(1);
        assertEquals(2, arrayList.getLengthOfArray());
    }

    @Test
    public void addTwoElements_insertElementInList_listSizeChanges(){
        assertTrue(arrayList.isEmpty());
        arrayList.add("goods");
        assertFalse(arrayList.isEmpty());
        arrayList.add("books");
        arrayList.insert("computers", 1);
        assertEquals("computers", arrayList.get(1));
    }

    @Test
    public void addTwoElements_insertElementAtEndOfList_listSizeRemainsChanged(){
        assertTrue(arrayList.isEmpty());
        arrayList.add("goods");
        assertFalse(arrayList.isEmpty());
        arrayList.add("books");
        assertThrows(ArrayIndexOutOfBoundsException.class, ()-> arrayList.insert("computers", 3));
    }

    @Test
    public void listIsEmpty_addThreeElementsToList_sizeOfListIsThree(){
        assertTrue(arrayList.isEmpty());
        assertEquals(0, arrayList.size());
        arrayList.add("goods");
        assertFalse(arrayList.isEmpty());
        arrayList.add("books");
        arrayList.add("computers");
        assertEquals(3, arrayList.size());
    }

    @Test
    public void listIsEmpty_addThreeElementsToList_clearList_sizeOfListIsZero(){
        assertTrue(arrayList.isEmpty());
        assertEquals(0, arrayList.size());
        arrayList.add("goods");
        assertFalse(arrayList.isEmpty());
        arrayList.add("books");
        arrayList.add("computers");
        assertEquals(3, arrayList.size());
        arrayList.clear();
        assertEquals(0, arrayList.size());
    }

}
