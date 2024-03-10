package test.executors;

import logic.executors.IncCommandExecutor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class IncCommandExecutorTest {

    private Stack<Integer> stack;

    @BeforeEach
    public void setUp() {
        stack = new Stack<>();
    }

    @Test
    public void testIncrementTopElement() {
        stack.push(1);
        IncCommandExecutor command = new IncCommandExecutor(stack);
        command.execute();
        Assertions.assertEquals(Integer.valueOf(2), stack.peek());
        Assertions.assertEquals(1, stack.size());
    }

    @Test
    public void testIncrementWithMultipleElements() {
        stack.push(1);
        stack.push(2);
        IncCommandExecutor command = new IncCommandExecutor(stack);
        command.execute();
        Assertions.assertEquals(Integer.valueOf(3), stack.peek());
        Assertions.assertEquals(2, stack.size());
    }

    @Test
    public void testIncrementEmptyStack() {
        IncCommandExecutor command = new IncCommandExecutor(stack);
        assertThrows(RuntimeException.class, command::execute);
    }
}
