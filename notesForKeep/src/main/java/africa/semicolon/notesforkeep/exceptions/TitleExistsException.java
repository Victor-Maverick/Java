package africa.semicolon.notesforkeep.exceptions;

public class TitleExistsException extends NoteManagerException{
    public TitleExistsException(String message) {
        super(message);
    }
}
