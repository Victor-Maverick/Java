package services;

import data.exceptions.DiaryAlreadyExistsException;
import data.exceptions.DiaryNotFoundException;
import data.model.Diary;
import data.model.Entry;
import data.repository.DiaryRepository;
import data.repository.DiaryRepositoryImp;
import dtos.request.RegisterRequest;

import java.util.ArrayList;
import java.util.List;

public class DiaryServicesImp implements DiaryServices{
    private DiaryRepository diaryRepository = new DiaryRepositoryImp();
    private long count;

    @Override
    public void register(RegisterRequest registerRequest) {
        validateUsername(registerRequest);
        Diary diary = new Diary(registerRequest.getUsername(), registerRequest.getPassword());
        diaryRepository.save(diary);


    }

    private void validateUsername(RegisterRequest registerRequest) {
        if (diaryRepository.findByUsername(registerRequest.getUsername()) != null)
            throw new DiaryAlreadyExistsException("Diary exists with that username");
    }

    @Override
    public void login() {

    }

    public int getNumberOfUsers(){
        return diaryRepository.findAll().size();
    }
}
