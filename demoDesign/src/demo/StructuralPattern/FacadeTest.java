package demo.StructuralPattern;

interface ComputerMethod{
    public void startup();
    public void shutdown();
}

class Cpu implements ComputerMethod{
    @Override
    public void startup() {
        System.out.println("cup startup");
    }

    @Override
    public void shutdown() {
        System.out.println("cup shutdown");
    }
}

class Memory implements ComputerMethod{

    @Override
    public void startup() {
        System.out.println("memory startup");
    }

    @Override
    public void shutdown() {
        System.out.println("memory shutdown");
    }
}

class Disk implements ComputerMethod{
    @Override
    public void startup() {
        System.out.println("disk startup");
    }

    @Override
    public void shutdown() {
        System.out.println("disk shutdown");
    }
}

class Computer implements ComputerMethod{
    private Cpu cpu;
    private Memory memory;
    private Disk disk;
    public Computer(){
        this.cpu = new Cpu();
        this.memory = new Memory();
        this.disk = new Disk();
    }
    @Override
    public void startup() {
        System.out.println("start computer begin");
        cpu.startup();
        memory.startup();
        disk.startup();
        System.out.println("start computer finish");

    }

    @Override
    public void shutdown() {
        System.out.println("shutdown computer begin");
        cpu.shutdown();
        memory.shutdown();
        disk.shutdown();
        System.out.println("shutdown computer finish");

    }
}

public class FacadeTest {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.startup();
        computer.shutdown();
    }


}
