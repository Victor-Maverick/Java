package africa.semicolon.gistLover.exceptions;

public class UserExistsException extends GistLoverAppException{
    public UserExistsException(String message) {
        super(message);
    }
}
