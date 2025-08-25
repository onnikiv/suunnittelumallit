package composite;

import java.util.ArrayList;

public class Organization extends Component {

    private final ArrayList<Component> children;
    private double salary;
    private String name;

    public Organization() {
        this.children = new ArrayList<>();
        this.salary = 0;
    }

    @Override
    public void addDepartment(Department department) {
        this.children.add(department);
    }

    @Override
    public void addEmployee(Employee employee) {
        this.children.add(employee);
    }

    @Override
    public double getSalary() {
        for (Component child : children) {
            this.salary += child.getSalary();
        }
        return salary;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void printOrganizationSalary() {
        System.out.println("Salary summary of the Organization: " + getSalary());
    }

    public void printOrganizationStructure() {
        System.out.println("<" + this.getClass().getSimpleName() + ">");
        for (Component child : children) {
            System.out.println("    <" + child.getClass().getSimpleName() + ">");
            System.out.println("        " + child.getName());
            for (Component subChild : child.getAllChildren()) {
                System.out.println("            " + subChild.getName());
            }
            System.out.println("    </" + child.getClass().getSimpleName() + ">");
        }
        System.out.println("<" + this.getClass().getSimpleName() + ">");
    }

    @Override
    public ArrayList<Component> getAllChildren() {
        return children;
    }
}
