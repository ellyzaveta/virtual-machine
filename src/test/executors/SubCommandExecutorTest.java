package test.executors;

import logic.executors.SubCommandExecutor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SubCommandExecutorTest {

    private Stack<Integer> stack;

    @BeforeEach
    public void setUp() {
        stack = new Stack<>();
    }

    @Test
    public void testSubTopTwoElements() {
        stack.push(1);
        stack.push(2);
        SubCommandExecutor command = new SubCommandExecutor(null, stack);
        command.execute();
        Assertions.assertEquals(1, stack.size());
        Assertions.assertEquals(Integer.valueOf(-1), stack.peek());
    }

    @Test
    public void testAddTopElementAndArg() {
        stack.push(5);
        SubCommandExecutor command = new SubCommandExecutor(3, stack);
        command.execute();
        Assertions.assertEquals(1, stack.size() );
        Assertions.assertEquals(Integer.valueOf(-2), stack.peek());
    }

    @Test
    public void testEmptyStack() {
        SubCommandExecutor command = new SubCommandExecutor(1, stack);
        assertThrows(RuntimeException.class, command::execute);
    }

    @Test
    public void testInsufficientElements() {
        stack.push(1);
        SubCommandExecutor command = new SubCommandExecutor(null, stack);
        assertThrows(RuntimeException.class, command::execute);
    }
}
