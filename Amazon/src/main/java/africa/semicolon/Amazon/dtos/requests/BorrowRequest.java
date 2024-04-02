package africa.semicolon.Amazon.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BorrowRequest {
    private String title;
    private String author;
    private String username;
}
