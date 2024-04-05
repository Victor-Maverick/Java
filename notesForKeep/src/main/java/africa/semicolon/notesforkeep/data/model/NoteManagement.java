package africa.semicolon.notesforkeep.data.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class NoteManagement {
    private List<User> noteList = new ArrayList<>();

}
