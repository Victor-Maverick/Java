package diaryAppTests;

import data.model.Entry;
import data.repository.EntryRepository;
import data.repository.EntryRepositoryImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class EntryRepositoryImpTest {
    private EntryRepository entryRepository;

    @BeforeEach
    public void setup(){
        entryRepository = new EntryRepositoryImp();
    }

    @Test
    public void saveNewEntryCountIncreasesTest(){
        Entry entry = new Entry();
        entryRepository.save(entry);
        assertEquals(1, entryRepository.count());
    }

    @Test
    public void addNewEntryToListOfEntries_findByIdReturnsEntryTest(){
        Entry entry = new Entry();
        entryRepository.save(entry);
        Entry foundEntry = entryRepository.findById(1);
        assertEquals(1, foundEntry.getId());
    }

    @Test
    public void addEntryDeleteById_ListOfEntriesDecreasesTest(){
        Entry entry = new Entry();
        entryRepository.save(entry);
        entryRepository.delete(1);
        assertEquals(0, entryRepository.count());
    }


    @Test
    public void addEntryDeleteByEntry_listOfEntriesDecreasesTest(){
        Entry entry = new Entry();
        entryRepository.save(entry);
        entryRepository.delete(entry);
        assertEquals(0, entryRepository.count());
    }


    @Test
    public void addEntriesToList_findAllReturnsListTest(){
        Entry entry = new Entry();
        Entry entry2 = new Entry();
        entryRepository.save(entry);
        entryRepository.save(entry2);
        List<Entry> entries = new ArrayList<>();
        entries.add(entry);
        entries.add(entry2);
        assertEquals(entries, entryRepository.findAll());
    }

    @Test
    public void addEntry_updateEntry_entryIdIsSameTest(){
        Entry entry = new Entry();
        entryRepository.save(entry);
        assertEquals(1, entry.getId());
        Entry foundEntry = new Entry();
        entryRepository.save(foundEntry);
        foundEntry.setId(1);
        foundEntry.setTitle("title");
        foundEntry.setBody("body");
        assertEquals(1, foundEntry.getId());
    }

    @Test
    public void addTwoEntries_entryIdChangesTest(){
        Entry entry = new Entry();
        entryRepository.save(entry);
        assertEquals(1, entry.getId());
        Entry foundEntry = new Entry();
        entryRepository.save(foundEntry);
        assertEquals(2, foundEntry.getId());
    }

}
