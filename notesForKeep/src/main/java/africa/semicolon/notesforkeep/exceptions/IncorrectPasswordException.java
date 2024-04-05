package africa.semicolon.notesforkeep.exceptions;

public class IncorrectPasswordException extends NoteManagerException{
    public IncorrectPasswordException(String message) {
        super(message);
    }
}
