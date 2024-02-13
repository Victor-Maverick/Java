import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class MySetTest {
    private MySet mySet;

    @BeforeEach
    public void beginEachWith() {
        mySet = new MySet();
    }

    @Test
    public void setIsEmptyOnCreationTest() {
        assertTrue(mySet.isEmpty());
    }

    @Test
    public void addElementToList_listIsNotEmptyTest() {
        assertTrue(mySet.isEmpty());
        mySet.add("groceries");
        assertFalse(mySet.isEmpty());

    }

    @Test
    public void addElementToList_removeElement_listIsEmptyTest() {
        assertTrue(mySet.isEmpty());
        mySet.add("groceries");
        assertFalse(mySet.isEmpty());
        mySet.remove("groceries");
        assertTrue(mySet.isEmpty());

    }

    @Test
    public void addTwoElementToList_removeOne_listIsNotEmptyTest() {
        assertTrue(mySet.isEmpty());
        mySet.add("groceries");
        mySet.add("rolls");
        mySet.remove("rolls");
        assertFalse(mySet.isEmpty());

    }
    @Test
    public void removeElementFromEmptyList_throwsException(){
        assertTrue(mySet.isEmpty());
        assertThrows(IllegalArgumentException.class, ()-> mySet.remove("rolls"));
    }

    @Test
    public void addTwoSameElements_sizeOfListIsOne(){
        assertTrue(mySet.isEmpty());
        mySet.add("rolls");
        assertEquals(1, mySet.size());
        mySet.add("rolls");
        assertEquals(1, mySet.size());
    }

    @Test
    public void addElementToSet_searchIfSetHasElement(){
        assertTrue(mySet.isEmpty());
        mySet.add("rolls");
        assertTrue(mySet.contains("rolls"));
    }

}