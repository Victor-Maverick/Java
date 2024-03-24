package springDiary.exceptions;

public class NonExistentEntryException extends DiaryAppException{
    public NonExistentEntryException(String message) {
        super(message);
    }
}
