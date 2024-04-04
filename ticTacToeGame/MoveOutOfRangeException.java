package ticTacToeGame;

public class MoveOutOfRangeException extends RuntimeException{
    public MoveOutOfRangeException(String message){
        super(message);
    }
}
