package logic.executors;

import data.ExecutionResult;
import logic.CommandExecutor;

import static data.ExecutionResultType.JUMP;

public class JumpCommandExecutor implements CommandExecutor {

    private final Integer arg;

    public JumpCommandExecutor(Integer arg) {
        this.arg = arg - 1;
    }

    @Override
    public ExecutionResult execute() {
        return new ExecutionResult(JUMP, arg);
    }
}
