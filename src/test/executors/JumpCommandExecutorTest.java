package test.executors;

import data.ExecutionResult;
import logic.executors.JumpCommandExecutor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JumpCommandExecutorTest {

    @Test
    public void testJumpCommandWithPositiveArg() {
        Integer arg = 5;
        JumpCommandExecutor command = new JumpCommandExecutor(arg);
        ExecutionResult result = command.execute();
        Assertions.assertNotNull(result);
        assertEquals( 4, result.getJumpIndex());
    }
}
