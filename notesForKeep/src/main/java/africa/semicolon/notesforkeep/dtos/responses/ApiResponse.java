package africa.semicolon.notesforkeep.dtos.responses;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class ApiResponse {
    private boolean isSuccessful;
    private Object response;
}
