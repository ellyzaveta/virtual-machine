package logic.executors;

import data.ExecutionResult;
import logic.CommandExecutor;

import java.util.Stack;

import static data.ExecutionResultType.CONTINUE;
import static data.ExecutionResultType.JUMP;

public class JumpIfCommandExecutor implements CommandExecutor {

    private final Integer arg;
    private final Stack<Integer> stack;

    public JumpIfCommandExecutor(Integer arg, Stack<Integer> stack) {
        this.arg = arg - 1;
        this.stack = stack;
    }

    @Override
    public ExecutionResult execute() {
        if (stack.peek() != 0) {
            return new ExecutionResult(JUMP, arg);
        } else {
            return new ExecutionResult(CONTINUE);
        }
    }

}
