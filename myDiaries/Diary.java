package myDiaries;

import myDiaries.Exceptions.EntryNotFoundException;
import myDiaries.Exceptions.IncorrectPasswordException;

import java.util.ArrayList;
import java.util.List;

public class Diary {
    private String username;
    private String password;
    private boolean isLocked = true;
    private int idNumbers;
    private final List<Entry> entries = new ArrayList<>();
    public boolean isLocked() {
        return isLocked;
    }

    public Diary(String username, String password){
        this.username = username;
        this.password = password;
    }
    public void lockDiary() {
        isLocked = true;
    }

    public void unlockDiary(String password) {
        validate(password);
        isLocked = false;
    }

    private void validate(String password) {
        if(!this.password.equals(password)) throw new IncorrectPasswordException("Wrong password");
    }


    public void createEntry(String title, String body) {
        int id = generateId();
        Entry newEntry =  new Entry(id, title, "body");
        entries.add(newEntry);
    }

    private int generateId() {
        return ++idNumbers;
    }

    public int checkEntryList() {
        return entries.size();
    }

    public Entry findEntryById(int idNumber) {
        for(Entry entry: entries)
            if (entry.getId() == idNumber) return entry;

        return null;
    }

    public void deleteEntry(int id) {
        Entry foundEntry = findEntryById(id);
        validateEntry(foundEntry);
        entries.remove(foundEntry);
    }

    private void validateEntry(Entry foundEntry) {
        if(!entries.contains(foundEntry))throw new EntryNotFoundException("Entry not found");
    }

    public void updateEntry(int id, String title, String body) {
        Entry foundEntry = findEntryById(id);
        validateEntry(foundEntry);
        foundEntry.editTitle(title);
        foundEntry.editBody(body);
    }

    public String getUsername(){
        return username;
    }

    public String getPassword() {
        return password;
    }
}
