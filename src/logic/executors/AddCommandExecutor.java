package logic.executors;

import data.ExecutionResult;
import logic.CommandExecutor;
import logic.exceptions.ArgumentsException;
import logic.exceptions.EmptyStackException;

import java.util.Stack;

import static data.ExecutionResultType.CONTINUE;

public class AddCommandExecutor implements CommandExecutor {

    private final Integer arg;
    private final Stack<Integer> stack;

    public AddCommandExecutor(Integer arg, Stack<Integer> stack) {
        this.arg = arg;
        this.stack = stack;
    }

    @Override
    public ExecutionResult execute() {

        if (stack.isEmpty()) throw new EmptyStackException();

        if (arg == null) {
            performOperationWithTopTwoElements();
        } else {
            performOperationWithTopElementAndArg();
        }

        return new ExecutionResult(CONTINUE);

    }

    private void performOperationWithTopTwoElements() {

        if (stack.size() < 2) {
            throw new ArgumentsException();
        }

        stack.push(stack.pop() + stack.pop());
    }

    private void performOperationWithTopElementAndArg() {
        stack.push(stack.pop() + arg);
    }
}
