package logic.executors;

import data.ExecutionResult;
import logic.CommandExecutor;

import java.util.EmptyStackException;
import java.util.Stack;

import static data.ExecutionResultType.CONTINUE;

public class PrintCommandExecutor implements CommandExecutor {

    private final Stack<Integer> stack;

    public PrintCommandExecutor(Stack<Integer> stack) {
        this.stack = stack;
    }

    @Override
    public ExecutionResult execute() {
        if(stack.isEmpty()) throw new EmptyStackException();

        System.out.println(stack.peek());
        return new ExecutionResult(CONTINUE);
    }
}
