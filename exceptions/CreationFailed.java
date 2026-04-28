package exceptions;

public class CreationFailed extends RuntimeException {
    public CreationFailed(String message) {
        super(message);
    }
}
