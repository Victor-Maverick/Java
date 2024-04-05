package africa.semicolon.notesforkeep.exceptions;

public class NoteNotFoundException extends NoteManagerException{
    public NoteNotFoundException(String message) {
        super(message);
    }
}
