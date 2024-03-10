package logic.executors;

import data.ExecutionResult;
import logic.CommandExecutor;

import java.util.Stack;

import static data.ExecutionResultType.CONTINUE;

public class PushCommandExecutor implements CommandExecutor {

    private final Integer arg;
    private final Stack<Integer> stack;

    public PushCommandExecutor(Integer arg, Stack<Integer> stack) {
        this.arg = arg;
        this.stack = stack;
    }

    @Override
    public ExecutionResult execute() {
        stack.push(arg);
        return new ExecutionResult(CONTINUE);
    }
}
