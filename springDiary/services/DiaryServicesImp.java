package springDiary.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springDiary.exceptions.DiaryNotFoundException;
import springDiary.exceptions.IncorrectPasswordException;
import springDiary.exceptions.UsernameAlreadyExistsException;
import springDiary.data.model.Diary;
import springDiary.data.model.Entry;
import springDiary.data.repository.DiaryRepository;
import springDiary.dtos.request.CreateEntryRequest;
import springDiary.dtos.request.LoginRequest;
import springDiary.dtos.request.RegisterRequest;

import java.util.List;
import java.util.Optional;

@Service
public class DiaryServicesImp implements DiaryServices{
    @Autowired
    private DiaryRepository diaryRepository;
    @Autowired
    private EntryServices entryServices;


    public void register(RegisterRequest registerRequest) {
        validateUsername(registerRequest);
        Diary diary = new Diary();
        diary.setUsername(registerRequest.getUsername());
        diary.setPassword(registerRequest.getPassword());
        diaryRepository.save(diary);

    }

    private void validateUsername(RegisterRequest registerRequest) {
        if (diaryRepository.findById(registerRequest.getUsername()).isPresent())
            throw new UsernameAlreadyExistsException("Diary exists with that username");
    }

    @Override
    public void login(LoginRequest loginRequest) {
        Diary diary = findBy(loginRequest.getUsername());
        String diaryPassword = diary.getPassword();
        String providedPassword = loginRequest.getPassword();
        if (!diaryPassword.equals(providedPassword))throw new IncorrectPasswordException("incorrect password");
        diary.setLocked(false);
        diaryRepository.save(diary);

    }

    public int getNumberOfUsers(){
        return diaryRepository.findAll().size();
    }


    public Diary findBy(String username) {
        Optional<Diary> diary = diaryRepository.findById(username);
        if(diary.isEmpty())throw new DiaryNotFoundException("diary not found");
        return diary.get();
    }

    @Override
    public void logout(String username) {
        Diary diary = findBy(username);
        diary.setLocked(true);
        diaryRepository.save(diary);

    }

    public List<Diary> findAll(){
        return diaryRepository.findAll();
    }

    @Override
    public void createEntryWith(CreateEntryRequest entryRequest) {
        Diary foundDiary = findBy(entryRequest.getAuthor());
        if (foundDiary.isLocked())throw new DiaryNotFoundException("not your diary");
        entryServices.addEntryWith(entryRequest);
    }
    @Override
    public List<Entry> findEntriesFor(String username) {
        return entryServices.findEntriesFor(username);
    }

    @Override
    public List<Entry> findAllEntries() {
        return entryServices.findAllEntries();
    }

    @Override
    public void deleteEntryBy(String title, String author) {
        entryServices.deleteWith(title, author);
    }


}
