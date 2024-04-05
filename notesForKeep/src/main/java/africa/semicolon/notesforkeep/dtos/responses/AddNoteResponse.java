package africa.semicolon.notesforkeep.dtos.responses;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AddNoteResponse {
    private String id;
    private String header;
    private LocalDateTime dateCreated;
}
