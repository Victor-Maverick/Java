package springDiary.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springDiary.exceptions.NonExistingAuthorException;
import springDiary.data.model.Entry;
import springDiary.data.repository.EntryRepository;
import springDiary.dtos.request.CreateEntryRequest;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntryServicesImp implements EntryServices {
    @Autowired
    private EntryRepository entryRepository;
    @Override
    public void addEntryWith(CreateEntryRequest entryRequest) {
        Entry entry = new Entry();
        entry.setTitle(entryRequest.getTitle());
        entry.setBody(entryRequest.getBody());
        entry.setAuthor(entryRequest.getAuthor());
        entryRepository.save(entry);
    }

    @Override
    public void deleteWith(String title) {
        Entry entry = entryRepository.findByTitle(title);
        entryRepository.delete(entry);

    }

    @Override
    public int getNumberOfEntries() {
        return entryRepository.findAll().size();
    }

    @Override
    public List<Entry> findAllEntries() {
        return entryRepository.findAll();
    }

    @Override
    public List<Entry> findEntriesFor(String username) {
        if(!validateAuthor(username))throw new NonExistingAuthorException("author does not exist");
        List<Entry> userEntries = new ArrayList<>();
        entryRepository.findAll().forEach(entry -> {if(entry.getAuthor().equals(username)) userEntries.add(entry);});
        return userEntries;
    }
    private boolean validateAuthor(String username){
        for(Entry entry : entryRepository.findAll()){
            if (entry.getAuthor().equals(username))return true;
        }
        return false;
    }

}
