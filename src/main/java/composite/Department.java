package composite;

import java.util.ArrayList;

public class Department extends Component {

    private final String name;
    private final ArrayList<Component> children;

    public Department(String name) {
        this.name = name;
        this.children = new ArrayList<>();
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
        double totalSalary = 0;
        for (Component child : children) {
            totalSalary += child.getSalary();
        }
        return totalSalary;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void removeDepartment(Department department) {
        children.remove(department);
    }

    @Override
    public void removeEmployee(Employee employee) {
        children.remove(employee);
    }
}
