package africa.semicolon.gistLover.dtos;

import africa.semicolon.gistLover.exceptions.GistLoverAppException;

public class NonExistingPostException extends GistLoverAppException {
    public NonExistingPostException(String message) {
        super(message);
    }
}
