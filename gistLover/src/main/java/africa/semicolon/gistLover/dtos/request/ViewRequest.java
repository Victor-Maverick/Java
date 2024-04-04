package africa.semicolon.gistLover.dtos.request;

import africa.semicolon.gistLover.data.model.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ViewRequest {
    private String title;
    private String username;
    private LocalDateTime dateViewed = LocalDateTime.now();
}
