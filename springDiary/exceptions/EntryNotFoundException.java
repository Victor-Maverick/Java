package springDiary.exceptions;

public class EntryNotFoundException extends DiaryAppException{
    public EntryNotFoundException(String message){
        super(message);
    }
}
