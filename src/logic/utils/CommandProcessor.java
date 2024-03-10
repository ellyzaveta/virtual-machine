package logic.utils;

import data.CommandType;
import logic.exceptions.IncorrectCommandException;

import java.util.Optional;

public class CommandProcessor {

    public static Optional<Integer> getArg(String command) {
        String[] args = command.split(" ");

        if(args.length > 1) {
            return Optional.of(Integer.parseInt(command.split(" ")[1]));
        } else return Optional.empty();

    }

    public static CommandType getCommand(String command) {
        String instructionStr = command.split(" ")[0];

        try {
            return CommandType.valueOf(instructionStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IncorrectCommandException();
        }
    }

    public static boolean isArgsRequired(CommandType command) {
        return command == CommandType.PUSH || command == CommandType.JUMP || command == CommandType.JUMP_IF;
    }

}
