package vm;

import data.ExecutionResult;
import logic.CommandExecutor;
import logic.CommandExecutorFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VirtualMachine {

    private List<CommandExecutor> program;
    private final Stack<Integer> stack;
    private int linePointer = 0;

    public VirtualMachine(Path filePath) {
        stack = new Stack<>();
        loadCommands(filePath);
    }

    public VirtualMachine(List<String> commands) {
        stack = new Stack<>();
        loadCommandsFromList(commands);
    }

    private void loadCommandsFromList(List<String> commands) {
        program = commands.stream()
                .filter(s -> !(s.isBlank() || s.startsWith("//")))
                .map(s -> CommandExecutorFactory.createCommandExecutor(s, stack))
                .collect(Collectors.toList());
    }

    private void loadCommands(Path filePath) {
        try (Stream<String> lines = Files.lines(filePath)) {
            program = lines
                    .filter(s -> !(s.isBlank() || s.startsWith("//")))
                    .map(s -> CommandExecutorFactory.createCommandExecutor(s, stack))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file", e);
        }
    }

    public void execute() {
        while (linePointer < program.size()) {

            ExecutionResult executionResult = program.get(linePointer).execute();

            switch (executionResult.getType()) {
                case CONTINUE -> linePointer++;
                case JUMP -> linePointer = executionResult.getJumpIndex();
            }
        }
    }

}
