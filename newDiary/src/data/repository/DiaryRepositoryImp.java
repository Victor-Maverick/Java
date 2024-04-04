package data.repository;

import data.exceptions.DiaryAlreadyExistsException;
import data.exceptions.DiaryNotFoundException;
import data.model.Diary;

import java.util.ArrayList;
import java.util.List;

public class DiaryRepositoryImp implements DiaryRepository{
    private List<Diary>diaries = new ArrayList<>();

    @Override
    public Diary save(Diary diary) {
        if(!isNew(diary)) throw new DiaryAlreadyExistsException("Diary exists");
        diaries.add(diary);
        return diary;
    }

    private boolean isNew(Diary diary) {
        for (Diary diary1 : diaries){
            if (diary1.getUsername().equals(diary.getUsername())) return false;
        }
        return true;
    }

    @Override
    public List<Diary> findAll() {
        return diaries;
    }

    @Override
    public Diary findByUsername(String username) {
        for (Diary diary : diaries){
            if (diary.getUsername().equals(username))return diary;
        }
        return null;
    }

    @Override
    public long count() {
        return diaries.size();
    }

    @Override
    public void delete(String username) {
        Diary foundDiary = findByUsername(username);
        if (foundDiary == null)throw new DiaryNotFoundException("no diary found");
        diaries.remove(foundDiary);
    }

    @Override
    public void delete(Diary diary) {
        Diary foundDiary = findByUsername(diary.getUsername());
        if (foundDiary == null)throw new DiaryNotFoundException("no diary found");
        diaries.remove(foundDiary);
    }


}
