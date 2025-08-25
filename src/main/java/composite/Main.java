package composite;

public class Main {

    public static void main(String[] args) {

        Organization organization = new Organization();

        Department department1 = new Department("Johtoporras");
        Department department2 = new Department("HR");
        Department department3 = new Department("Kaivostyöntekijät");

        Department department4 = new Department("Orjat");

        Employee employee1 = new Employee("Ylijohtaja Perttu", 100000);
        Employee employee2 = new Employee("Jorma", 3000);
        Employee employee3 = new Employee("Maurizio", 1400);
        Employee employee4 = new Employee("Onni", 3);

        department1.addEmployee(employee1);

        department2.addEmployee(employee2);

        department3.addEmployee(employee3);
        department3.addEmployee(employee4);

        organization.addDepartment(department1);
        organization.addDepartment(department2);
        organization.addDepartment(department3);

        department3.addDepartment(department4);

        organization.printOrganizationStructure();

    }
}
