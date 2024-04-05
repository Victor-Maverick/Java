package africa.semicolon.notesforkeep.data.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document("Note_Table")
public class Note {
    private String id;
    private String header;
    private String content;
    private User author;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;

}
