package africa.semicolon.notesforkeep.exceptions;

public class UserNotFoundException extends NoteManagerException{
    public UserNotFoundException(String message) {
        super(message);
    }
}
