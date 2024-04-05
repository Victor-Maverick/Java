package africa.semicolon.notesforkeep.dtos.request;

import lombok.Data;

@Data
public class UpdateRequest {
    private String title;
    private String newTitle;
    private String newContent;
    private String author;
}
