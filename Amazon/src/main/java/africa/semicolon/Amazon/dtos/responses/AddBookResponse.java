package africa.semicolon.Amazon.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddBookResponse {
    private String id;
    private String title;
    private String author;
    private Integer isbn;
    private String dateAdded;
}
