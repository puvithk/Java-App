package exceptions;

public class StopApplication extends RuntimeException {
    public StopApplication(String message) {
        super(message);
    }
}
