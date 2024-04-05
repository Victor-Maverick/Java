package africa.semicolon.notesforkeep.data.repository;

import africa.semicolon.notesforkeep.data.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Notes extends MongoRepository<Note, String> {

    Note findNoteBy(String title);
}
