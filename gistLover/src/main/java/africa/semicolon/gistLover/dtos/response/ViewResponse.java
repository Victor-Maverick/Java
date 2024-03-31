package africa.semicolon.gistLover.dtos.response;

import africa.semicolon.gistLover.data.model.User;
import lombok.Data;

@Data
public class ViewResponse {
    private String id;
    private User viewer;
    private String dateViewed;
}
