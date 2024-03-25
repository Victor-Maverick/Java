package springDiary.services;

import springDiary.data.model.Entry;
import springDiary.dtos.request.CreateEntryRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EntryServices {
    void addEntryWith(CreateEntryRequest entryRequest);

    void deleteWith(String title, String author);

    int getNumberOfEntries();

    List<Entry> findAllEntries();

    List<Entry> findEntriesFor(String username);
}
