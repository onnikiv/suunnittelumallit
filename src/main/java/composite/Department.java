package composite;

import java.util.ArrayList;

public class Department extends Component {

    private final String name;
    private double salary;

    private final ArrayList<Component> children;

    public Department(String name) {
        this.name = name;
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
    public ArrayList<Component> getAllChildren() {
        return children;
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
}
