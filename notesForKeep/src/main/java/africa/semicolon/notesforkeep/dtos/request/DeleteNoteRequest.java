package africa.semicolon.notesforkeep.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteNoteRequest {
    private String noteTitle;
    private String author;
}
