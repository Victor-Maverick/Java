package africa.semicolon.notesManager.data.repository;

import africa.semicolon.notesManager.data.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Notes extends MongoRepository<Note, String> {

}
