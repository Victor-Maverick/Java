package springDiary.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springDiary.exceptions.NonExistingAuthorException;
import springDiary.data.model.Entry;
import springDiary.data.repository.EntryRepository;
import springDiary.dtos.request.CreateEntryRequest;
import springDiary.exceptions.TitleExistsException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EntryServicesImp implements EntryServices {
    @Autowired
    private EntryRepository entryRepository;
    @Override
    public void addEntryWith(CreateEntryRequest entryRequest) {
        String entryTitle = entryRequest.getTitle();
        entryRepository.findAll().forEach(entry -> {if(entry.getTitle().equalsIgnoreCase(entryTitle)) throw new TitleExistsException("title exists");
        });
        Entry entry = new Entry();
        entry.setTitle(entryRequest.getTitle());
        entry.setBody(entryRequest.getBody());
        entry.setAuthor(entryRequest.getAuthor());
        entryRepository.save(entry);
    }

    @Override
    public void deleteWith(String title, String author) {
        Optional<Entry> entry = entryRepository.findByTitle(title);
        boolean entryExists = entryRepository.findEntryByAuthor(author);
        if (entry.isPresent() && entryExists)entryRepository.deleteByTitleAndAuthor(title, author);

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
