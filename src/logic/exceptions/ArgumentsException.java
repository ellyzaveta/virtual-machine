package logic.exceptions;

public class ArgumentsException extends RuntimeException {
    public ArgumentsException() {
        super("Not enough arguments given");
    }
}
