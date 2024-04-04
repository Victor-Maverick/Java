package africa.semicolon.Amazon.exceptions;

public class NonExistentUserException extends AmazonAppException{
    public NonExistentUserException(String message) {
        super(message);
    }
}
