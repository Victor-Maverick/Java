package africa.semicolon.gistLover.exceptions;

public class NonExistingUserException extends GistLoverAppException{
    public NonExistingUserException(String message) {
        super(message);
    }
}
