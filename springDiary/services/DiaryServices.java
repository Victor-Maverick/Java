package springDiary.services;

import springDiary.data.model.Diary;
import springDiary.data.model.Entry;
import springDiary.dtos.request.CreateEntryRequest;
import springDiary.dtos.request.LoginRequest;
import springDiary.dtos.request.RegisterRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface DiaryServices {


    void register(RegisterRequest registerRequest);


    void login(LoginRequest registerRequest);

    int getNumberOfUsers();

    Diary findBy(String username);

    void logout(String username);

    List<Diary> findAll();


    void createEntryWith(CreateEntryRequest entryRequest);

    List<Entry> findEntriesFor(String username);

    List<Entry> findAllEntries();

    void deleteEntryBy(String title);
}
