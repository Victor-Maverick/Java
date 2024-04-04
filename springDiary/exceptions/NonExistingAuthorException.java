package springDiary.exceptions;

public class NonExistingAuthorException extends DiaryAppException{
    public NonExistingAuthorException(String message) {
        super(message);
    }
}
