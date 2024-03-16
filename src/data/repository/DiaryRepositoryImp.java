package data.repository;

import data.model.Diary;

import java.util.ArrayList;
import java.util.List;

public class DiaryRepositoryImp implements DiaryRepository{
    private List<Diary>diaries = new ArrayList<>();

    @Override
    public Diary save(Diary diary) {
        diaries.add(diary);
        return diary;
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
        diaries.remove(foundDiary);
    }

    @Override
    public void delete(Diary diary) {
        Diary foundDiary = findByUsername(diary.getUsername());
        diaries.remove(foundDiary);
    }


}
