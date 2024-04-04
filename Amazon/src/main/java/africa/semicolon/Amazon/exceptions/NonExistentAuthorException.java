package africa.semicolon.Amazon.exceptions;

public class NonExistentAuthorException extends AmazonAppException{
    public NonExistentAuthorException(String message) {
        super(message);
    }
}
