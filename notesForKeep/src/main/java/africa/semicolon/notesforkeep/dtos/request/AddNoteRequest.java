package africa.semicolon.notesforkeep.dtos.request;

import lombok.Data;

@Data
public class AddNoteRequest {
    private String header;
    private String content;
    private String author;
}
