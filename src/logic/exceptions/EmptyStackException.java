package logic.exceptions;

public class EmptyStackException extends RuntimeException {
    public EmptyStackException() {
        super("Cannot perform operation: Stack is empty.");
    }
}