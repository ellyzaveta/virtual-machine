import vm.VirtualMachine;

import java.nio.file.Path;

public class Runner {

    public static void main(String[] args) {
        VirtualMachine virtualMachine = new VirtualMachine(Path.of("src","resources", "test.txt"));
        virtualMachine.execute();
    }
}
