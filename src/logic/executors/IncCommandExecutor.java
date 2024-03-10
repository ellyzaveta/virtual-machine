package logic.executors;

import data.ExecutionResult;
import logic.CommandExecutor;
import logic.exceptions.EmptyStackException;

import java.util.Stack;

import static data.ExecutionResultType.CONTINUE;

public class IncCommandExecutor implements CommandExecutor {

    private final Stack<Integer> stack;

    public IncCommandExecutor(Stack<Integer> stack) {
        this.stack = stack;
    }

    @Override
    public ExecutionResult execute() {
        if (!stack.isEmpty()) {
            stack.push(stack.pop() + 1);
            return new ExecutionResult(CONTINUE);
        } else throw new EmptyStackException();
    }
}
