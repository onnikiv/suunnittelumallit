package composite;

import java.util.ArrayList;

public class Employee extends Component {

    private final String name;
    private final double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public ArrayList<Component> getAllChildren() {
        return null;
    }

    // LEAF metodit
    @Override
    public void addDepartment(Department department) {
        throw new UnsupportedOperationException("Not possible buddy");
    }

    @Override
    public void addEmployee(Employee employee) {
        throw new UnsupportedOperationException("Not possible buddy");
    }

    @Override
    public void removeDepartment(Department department) {
        throw new UnsupportedOperationException("Not possible buddy");
    }

    @Override
    public void removeEmployee(Employee employee) {
        throw new UnsupportedOperationException("Not possible buddy");
    }
}
