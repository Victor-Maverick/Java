package myDiaries;

import myDiaries.Exceptions.DiaryNotFoundException;
import myDiaries.Exceptions.IncorrectPasswordException;

import java.util.ArrayList;
import java.util.List;

public class Diaries {
    private List<Diary> diaries = new ArrayList<>();

    public void add(String username, String password){
        Diary diary = new Diary(username, password);
        diaries.add(diary);
    }

    public int getListSize() {
        return diaries.size();
    }

    public Diary findByUsername(String username) {
        for(Diary diary : diaries){
            if (diary.getUsername().equalsIgnoreCase(username))
                return diary;
            throw new DiaryNotFoundException("diary not found");
        }
        return null;
    }

    public void delete(String username, String password) {
        Diary foundDiary = findByUsername(username);
        if(!foundDiary.getPassword().equalsIgnoreCase(password))throw new IncorrectPasswordException("wrong password");
        diaries.remove(foundDiary);
    }
}
