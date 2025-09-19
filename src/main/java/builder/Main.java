package builder;

import builder.concreteBuilders.GamingComputerBuilder;
import builder.concreteBuilders.OfficeComputerBuilder;

public class Main {

    public static void main(String[] args) {

        ComputerBuilder gaming_pc_builder = new GamingComputerBuilder();
        ComputerBuilder office_pc_builder = new OfficeComputerBuilder();

        ComputerDirector director1 = new ComputerDirector(gaming_pc_builder);
        ComputerDirector director2 = new ComputerDirector(office_pc_builder);

        director1.constructGamingComputer();
        director2.constructOfficeComputer();

        Computer gamingPC = gaming_pc_builder.getComputer();
        Computer officePC = office_pc_builder.getComputer();

        System.out.println(gamingPC);
        System.out.println(officePC);

    }
}
