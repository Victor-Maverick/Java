package springDiary.exceptions;

public class UsernameAlreadyExistsException extends DiaryAppException{
    public UsernameAlreadyExistsException(String message){
        super(message);
    }
}
