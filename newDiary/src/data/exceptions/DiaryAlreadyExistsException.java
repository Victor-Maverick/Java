package data.exceptions;

public class DiaryAlreadyExistsException extends RuntimeException{
    public DiaryAlreadyExistsException(String message){
        super(message);
    }
}
