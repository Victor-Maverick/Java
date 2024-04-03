package africa.semicolon.Amazon.dtos.requests;

import lombok.Data;

@Data
public class BorrowRequest {
    private String title;
    private String author;
    private String username;
}
