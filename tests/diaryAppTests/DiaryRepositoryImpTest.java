package diaryAppTests;

import data.exceptions.DiaryAlreadyExistsException;
import data.exceptions.DiaryNotFoundException;
import data.model.Diary;
import data.repository.DiaryRepository;
import data.repository.DiaryRepositoryImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DiaryRepositoryImpTest {
    private DiaryRepository diaryRepository;

    @BeforeEach
    public void startEachWith(){
        diaryRepository = new DiaryRepositoryImp();
    }

    @Test
    public void addDiaryListOfDiariesIncreasesTest(){

        Diary diary = new Diary("username", "password");
        diaryRepository.save(diary);
        assertEquals(1, diaryRepository.count());
    }

    @Test
    public void addDiaryListOfDiaries_findByUsernameTest(){
        Diary diary = new Diary("username", "password");
        diaryRepository.save(diary);
        Diary foundDiary = diaryRepository.findByUsername("username");
        assertEquals("username", foundDiary.getUsername());
    }

    @Test
    public void addDiary_deleteDiaryByUsername_listDecreasesTest(){
        Diary diary = new Diary("username", "password");
        diaryRepository.save(diary);
        diaryRepository.delete("username");
        assertEquals(0, diaryRepository.count());
    }

    @Test
    public void addDiary_deleteNonExistingDiaryByUsername_throwsExceptionTest(){
        Diary diary = new Diary("username", "password");
        diaryRepository.save(diary);
        assertThrows(DiaryNotFoundException.class, ()->diaryRepository.delete("wrong username"));
        assertEquals(1, diaryRepository.count());
    }
    @Test
    public void addDiary_deleteDiaryByDiary_listDecreasesTest(){
        Diary diary = new Diary("username", "password");
        diaryRepository.save(diary);
        diaryRepository.delete(diary);
        assertEquals(0, diaryRepository.count());
    }

    @Test
    public void addDiary_deleteNonExistingDiary_throwsExceptionTest(){
        Diary diary = new Diary("username", "password");
        diaryRepository.save(diary);
        assertThrows(DiaryNotFoundException.class, ()->diaryRepository.delete(new Diary("new", "pass")));
        assertEquals(1, diaryRepository.count());
    }

    @Test
    public void addDiariesToList_findAllReturnsListTest(){
        Diary diary = new Diary("username", "password");
        Diary diary2 = new Diary("usernames", "password");
        diaryRepository.save(diary);
        diaryRepository.save(diary2);
        List<Diary> diaries = new ArrayList<>();
        diaries.add(diary);
        diaries.add(diary2);
        assertEquals(diaries, diaryRepository.findAll());
    }

    @Test
    public void addTwoDiariesWithSameUsername_throwsExceptionTest(){
        Diary diary = new Diary("username", "password");
        Diary diary2 = new Diary("username", "password");
        diaryRepository.save(diary);
        assertThrows(DiaryAlreadyExistsException.class,()-> diaryRepository.save(diary2));
    }

}
