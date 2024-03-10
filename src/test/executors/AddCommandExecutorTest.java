package test.executors;

import logic.executors.AddCommandExecutor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class AddCommandExecutorTest {

    private Stack<Integer> stack;

    @BeforeEach
    public void setUp() {
        stack = new Stack<>();
    }

    @Test
    public void testAddTopTwoElements() {
        stack.push(1);
        stack.push(2);
        AddCommandExecutor command = new AddCommandExecutor(null, stack);
        command.execute();
        Assertions.assertEquals(1, stack.size());
        Assertions.assertEquals(Integer.valueOf(3), stack.peek());
    }

    @Test
    public void testAddTopElementAndArg() {
        stack.push(5);
        AddCommandExecutor command = new AddCommandExecutor(3, stack);
        command.execute();
        Assertions.assertEquals(1, stack.size() );
        Assertions.assertEquals(Integer.valueOf(8), stack.peek());
    }

    @Test
    public void testEmptyStack() {
        AddCommandExecutor command = new AddCommandExecutor(1, stack);
        assertThrows(RuntimeException.class, command::execute);
    }

    @Test
    public void testInsufficientElements() {
        stack.push(1);
        AddCommandExecutor command = new AddCommandExecutor(null, stack);
        assertThrows(RuntimeException.class, command::execute);
    }
}
