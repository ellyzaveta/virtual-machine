package test;

import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vm.VirtualMachine;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VirtualMachineTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final VirtualMachine vm = new VirtualMachine(Path.of("src","resources", "test.txt"));

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void testVirtualMachine() {
        int expected = -15;
        vm.execute();
        assertEquals(expected + System.lineSeparator(), outContent.toString());
    }

}