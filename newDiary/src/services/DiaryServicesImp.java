package services;

import data.model.Diary;
import data.model.Entry;
import dtos.request.RegisterRequest;

import java.util.ArrayList;
import java.util.List;

public class DiaryServicesImp implements DiaryServices{
    private List<Diary> diaries = new ArrayList<>();
    private List<Entry> entries = new ArrayList<>();
    private Diary diary;
    private long count;

    @Override
    public void register(RegisterRequest registerRequest) {
        diary = new Diary();
        diary.setUsername(registerRequest.getUsername());
        diary.setPassword(registerRequest.getPassword());
        diaries.add(diary);
        count++;
    }

    @Override
    public void login() {

    }

    public int getNumberOfUsers(){
        return (int) count;
    }
}
