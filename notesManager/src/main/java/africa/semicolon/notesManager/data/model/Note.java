package africa.semicolon.notesManager.data.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document("Note_Table")
public class Note {
    private String id;
    private String title;
    private String content;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
}
