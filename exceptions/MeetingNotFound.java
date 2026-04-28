package exceptions;

public class MeetingNotFound extends RuntimeException {
    public MeetingNotFound(String message) {
        super(message);
    }
}
