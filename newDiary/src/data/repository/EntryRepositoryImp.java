package data.repository;

import data.exceptions.EntryNotFoundException;
import data.model.Diary;
import data.model.Entry;

import java.util.ArrayList;
import java.util.List;

public class EntryRepositoryImp implements EntryRepository{
    private List<Entry> entries = new ArrayList<>();
    private int count;

    @Override
    public Entry save(Entry entry) {
        if(isNewEntry(entry)) saveAsNew(entry);
        return entry;
    }

    private void saveAsNew(Entry entry) {
        entry.setId(++count);
        entries.add(entry);
    }

    private boolean isNewEntry(Entry entry) {
        return entry.getId() == 0;
    }

    @Override
    public List<Entry> findAll() {
        return entries;
    }

    @Override
    public Entry findById(int id) {
        for(Entry entry : entries){
            if(entry.getId() == id)return entry;
        }
        return null;
    }

    @Override
    public long count() {
        return entries.size();
    }

    @Override
    public void delete(int id) {
        Entry foundEntry = findById(id);
        if (foundEntry == null) throw new EntryNotFoundException("no such entry");
        entries.remove(foundEntry);
    }

    @Override
    public void delete(Entry entry) {
        Entry foundEntry = findById(entry.getId());
        if (foundEntry == null) throw new EntryNotFoundException("no such entry");
        entries.remove(foundEntry);
    }
}
