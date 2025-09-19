package builder.concreteBuilders;

import builder.Component;
import builder.Computer;
import builder.ComputerBuilder;

public class GamingComputerBuilder implements ComputerBuilder {

    private final Computer computer;

    public GamingComputerBuilder() {
        computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        computer.addComponent(new Component("Intel i9"));
    }

    @Override
    public void buildRAM() {
        computer.addComponent(new Component("32 RAM"));
    }

    @Override
    public void buildHardDrive() {
        computer.addComponent(new Component("SSD 1T"));
    }

    @Override
    public void buildGraphicsCard() {
        computer.addComponent(new Component("NVIDIA RTX 9000"));
    }

    @Override
    public void buildOperatingSystem() {
        computer.addComponent(new Component("WINDOWS 11 PRO"));

    }

    @Override
    public Computer getComputer() {
        return computer;
    }

}
