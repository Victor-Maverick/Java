package springDiary.exceptions;

public class TitleExistsException extends DiaryAppException{
    public TitleExistsException(String message) {
        super(message);
    }
}
