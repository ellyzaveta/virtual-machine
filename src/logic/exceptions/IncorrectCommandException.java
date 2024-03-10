package logic.exceptions;

public class IncorrectCommandException extends RuntimeException {
    public IncorrectCommandException() {
        super("Command is not supported");
    }
}
