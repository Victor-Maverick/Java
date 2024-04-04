package springDiary.dtos.request;

import lombok.Data;

@Data
public class CreateEntryRequest {
    private String title;
    private String body;
    private String author;


}
