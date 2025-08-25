package composite;

public class Main {

    public static void main(String[] args) {

        Organization nokia = new Organization();

        nokia.addEmployee(new Employee("Ylijohtaja Perttu", 100000));

        Department johtoPorras = new Department("Johtoporras");
        Department kaivosHenkilöt = new Department("Kaivoshenkilöt");

        johtoPorras.addEmployee(new Employee("Jorma", 5000));

        kaivosHenkilöt.addEmployee(new Employee("Sakari", 1500));
        kaivosHenkilöt.addEmployee(new Employee("Elmo", 2000));

        nokia.addDepartment(johtoPorras);
        nokia.addDepartment(kaivosHenkilöt);

        nokia.addEmployee(new Employee("Onni", 20));

        Department testi = new Department("HR-Mammat");

        nokia.addDepartment(testi);

        nokia.printSalaryOfOrganization();
    }
}
