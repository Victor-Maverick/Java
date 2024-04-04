package springDiary.exceptions;

public class DiaryNotFoundException extends DiaryAppException{
    public DiaryNotFoundException(String message){
        super(message);
    }
}
