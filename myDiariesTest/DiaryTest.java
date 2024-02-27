package myDiariesTest;

import myDiaries.Diary;
import myDiaries.Entry;
import myDiaries.Exceptions.IncorrectPasswordException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiaryTest {
    private Diary diary;

    @BeforeEach
    public void startEachWith(){
        diary = new Diary("Username", "password");
    }

    @Test
    public void diaryIsLockedOnCreationTest(){
        assertTrue(diary.isLocked());
    }
    @Test
    public void createDiary_unLockDiary_lockDiary_diaryIsLockedTest(){
        assertTrue(diary.isLocked());
        diary.unlockDiary("password");
        diary.lockDiary();
        assertTrue(diary.isLocked());
    }

    @Test
    public void createDiary_unlockDiary_diaryIsUnlockedTest(){
        assertTrue(diary.isLocked());
        diary.unlockDiary("password");
        assertFalse(diary.isLocked());
    }

    @Test
    public void createDiary_lockDiary_unlockDiaryWithWrongPassword_throwsIncorrectPasswordExceptionTest(){
        assertTrue(diary.isLocked());
        assertThrows(IncorrectPasswordException.class, ()-> diary.unlockDiary("wrongPassword"));
        assertTrue(diary.isLocked());
    }

    @Test
    public void createEntry_entryListSizeIncreasesTest(){
        diary.createEntry("title", "password");
        assertEquals(1, diary.checkEntryList());
    }



   @Test
    public void createEntry_deleteEntry_listOfEntriesIsEmptyTest(){
       diary.createEntry("title", "body");
       assertEquals(1, diary.checkEntryList());
       diary.deleteEntry(1);
       assertEquals(0, diary.checkEntryList());
   }

   @Test
    public void createEntry_searchEntryById_returnsEntryTest(){
       diary.createEntry("title", "password");
       Entry foundEntry = diary.findEntryById(1);
       assertEquals(foundEntry, diary.findEntryById(1));
   }

   @Test
    public void createEntry_updateEntry_entryIsUpdatedTest(){
       diary.createEntry("title", "password");
       Entry foundEntry = diary.findEntryById(1);
       diary.updateEntry(1, "new title", "new body");
       assertEquals(foundEntry, diary.findEntryById(1));
   }

   @Test
   public void createEntry_deleteEntryWithWrongPassword_throwsInvalidPassWordExceptionTest(){
       diary.createEntry("title", "password");
   }

}
