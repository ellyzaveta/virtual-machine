package test.executors;

import logic.executors.PushCommandExecutor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class PushCommandExecutorTest {

    private Stack<Integer> stack;

    @BeforeEach
    public void setUp() {
        stack = new Stack<>();
    }

    @Test
    public void testPushNonNullArg() {
        Integer arg = 5;
        PushCommandExecutor command = new PushCommandExecutor(arg, stack);
        command.execute();
        Assertions.assertFalse(stack.isEmpty());
        Assertions.assertEquals(arg, stack.peek());
    }

    @Test
    public void testStackSizeAfterPush() {
        stack.push(1);
        Integer arg = 2;
        PushCommandExecutor command = new PushCommandExecutor(arg, stack);
        command.execute();
        Assertions.assertEquals(2, stack.size());
    }
}
