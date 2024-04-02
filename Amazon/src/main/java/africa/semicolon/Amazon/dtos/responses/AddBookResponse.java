package africa.semicolon.Amazon.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddBookResponse {
    private Integer id;
    private String title;
    private String author;
    private String isbn;
    private String dateAdded;
}
