package africa.semicolon.notesforkeep.dtos.responses;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdateResponse {
    private String updatedTitle;
    private String updatedContent;
    private LocalDateTime dateUpdated = LocalDateTime.now();
}
