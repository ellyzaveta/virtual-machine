package test.executors;

import data.ExecutionResult;
import logic.executors.JumpIfCommandExecutor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

public class JumpIfCommandExecutorTest {

    private Stack<Integer> stack;

    @BeforeEach
    public void setUp() {
        stack = new Stack<>();
    }

    @Test
    public void testJumpIfNonZeroTopElement() {
        stack.push(1); // Non-zero element
        Integer arg = 5;
        JumpIfCommandExecutor command = new JumpIfCommandExecutor(arg, stack);
        ExecutionResult result = command.execute();
        Assertions.assertNotNull(result);
        assertEquals(4, result.getJumpIndex());
    }

    @Test
    public void testContinueIfZeroTopElement() {
        stack.push(0); // Zero element
        Integer arg = 5;
        JumpIfCommandExecutor command = new JumpIfCommandExecutor(arg, stack);
        ExecutionResult result = command.execute();
        assertNotNull( result);
        assertNull(result.getJumpIndex());
    }

    @Test
    public void testExecutionWithEmptyStack() {
        Integer arg = 5;
        JumpIfCommandExecutor command = new JumpIfCommandExecutor(arg, stack);
        assertThrows(RuntimeException.class, command::execute);
    }
}
