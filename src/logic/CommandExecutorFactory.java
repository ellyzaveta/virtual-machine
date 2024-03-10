package logic;

import logic.exceptions.IncorrectCommandException;
import logic.executors.*;
import data.*;

import java.util.Optional;
import java.util.Stack;

import static logic.utils.CommandProcessor.*;

public class CommandExecutorFactory {

    public static CommandExecutor createCommandExecutor(String command, Stack<Integer> stack) {

        CommandType commands = getCommand(command);
        Optional<Integer> value = getArg(command);

        if (isArgsRequired(commands) && value.isEmpty()) throw new IncorrectCommandException();

        Integer arg = null;
        if(value.isPresent()) arg = value.get();

        return switch (commands) {
            case PUSH -> new PushCommandExecutor(arg, stack);
            case INC -> new IncCommandExecutor(stack);
            case ADD -> new AddCommandExecutor(arg, stack);
            case SUB -> new SubCommandExecutor(arg, stack);
            case JUMP -> new JumpCommandExecutor(arg);
            case JUMP_IF -> new JumpIfCommandExecutor(arg, stack);
            case PRINT -> new PrintCommandExecutor(stack);
        };
    }

}
