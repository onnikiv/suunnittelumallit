package builder.concreteBuilders;

import builder.Component;
import builder.Computer;
import builder.ComputerBuilder;

public class OfficeComputerBuilder implements ComputerBuilder {

    private final Computer computer;

    public OfficeComputerBuilder() {
        computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        computer.addComponent(new Component("Intel i3"));
    }

    @Override
    public void buildRAM() {
        computer.addComponent(new Component("8 RAM"));
    }

    @Override
    public void buildHardDrive() {
        computer.addComponent(new Component("HDD 120GB"));
    }

    @Override
    public void buildGraphicsCard() {
        computer.addComponent(new Component("GTX 160"));
    }

    @Override
    public void buildOperatingSystem() {
        computer.addComponent(new Component("WINDOWS XP"));

    }

    @Override
    public Computer getComputer() {
        return computer;
    }

}
