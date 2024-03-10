package data;

public class ExecutionResult {
    private final ExecutionResultType type;
    private final Integer jumpIndex;

    public ExecutionResult(ExecutionResultType type) {
        this(type, null);
    }

    public ExecutionResult(ExecutionResultType type, Integer jumpIndex) {
        this.type = type;
        this.jumpIndex = jumpIndex;
    }

    public ExecutionResultType getType() {
        return type;
    }

    public Integer getJumpIndex() {
        return jumpIndex;
    }
}
