package test.executors;

import logic.executors.PrintCommandExecutor;
import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PrintCommandExecutorTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private Stack<Integer> stack;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        stack = new Stack<>();
    }

    @After
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void testPrintWithEmptyStack() {
        PrintCommandExecutor command = new PrintCommandExecutor(stack);
        assertThrows(RuntimeException.class, command::execute);
    }

    @Test
    public void testPrintWithNonEmptyStack() {
        int value = 5;
        stack.push(5);
        PrintCommandExecutor command = new PrintCommandExecutor(stack);
        command.execute();
        assertEquals(value + System.lineSeparator(), outContent.toString());
    }
}
