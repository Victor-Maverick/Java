package africa.semicolon.gistLover.dtos;

import lombok.Data;

@Data
public class CreatePostRequest {
    private String title;
    private String content;
}
