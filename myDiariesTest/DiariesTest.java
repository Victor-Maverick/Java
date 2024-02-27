package myDiariesTest;

import myDiaries.Diaries;
import myDiaries.Diary;
import myDiaries.Exceptions.DiaryNotFoundException;
import myDiaries.Exceptions.IncorrectPasswordException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DiariesTest {
    private Diaries diaries;

    @BeforeEach
    public void setUp(){
        diaries = new Diaries();
    }

    @Test
    public void createDiary_addDiaryToDiaries_SizeOfDiariesListIncreasesTest(){
        diaries.add("username", "password");
        assertEquals(1, diaries.getListSize());
    }

    @Test
    public void createDiary_addDiaryToDiaries_findByUsername_returnsDiaryCreatedTest(){
        diaries.add("username", "password");
        Diary foundDiary = diaries.findByUsername("username");
        assertEquals(foundDiary, diaries.findByUsername("username"));
    }

    @Test
    public void createTwoDiaries_deleteADiary_diaryListDecreasesTest(){
        diaries.add("username", "password");
        diaries.add("second user", "password");
        assertEquals(2, diaries.getListSize());
        diaries.delete("username", "password");
        assertEquals(1, diaries.getListSize());
    }

    @Test
    public void createDiary_deleteDiaryWithWrongPassword_throwsIncorrectPasswordExceptionTest(){
        diaries.add("username", "password");
        assertThrows(IncorrectPasswordException.class,()->diaries.delete("username", "wrong password"));

    }
    @Test
    public void createDiary_deleteDiaryWithWrongUsername_throwsDiaryNotFoundExceptionTest(){
        diaries.add("username", "password");
        assertThrows(DiaryNotFoundException.class,()->diaries.delete("wrong username", "password"));
    }

}
