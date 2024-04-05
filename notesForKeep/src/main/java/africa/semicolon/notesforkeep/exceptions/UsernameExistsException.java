package africa.semicolon.notesforkeep.exceptions;

public class UsernameExistsException extends NoteManagerException{
    public UsernameExistsException(String message) {
        super(message);
    }
}
