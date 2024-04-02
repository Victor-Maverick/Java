package africa.semicolon.Amazon.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddBookRequest {
    private String bookTitle;
    private String author;
    private String isbn;

}
