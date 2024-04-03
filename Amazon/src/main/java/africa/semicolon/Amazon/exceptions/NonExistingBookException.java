package africa.semicolon.Amazon.exceptions;

public class NonExistingBookException extends AmazonAppException{
    public NonExistingBookException(String message) {
        super(message);
    }
}
