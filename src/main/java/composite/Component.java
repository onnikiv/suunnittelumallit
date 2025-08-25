package composite;

import java.util.ArrayList;

public abstract class Component {

    public abstract void addDepartment(Department department);

    public abstract void addEmployee(Employee employee);

    public abstract double getSalary();

    public abstract String getName();

    public abstract ArrayList<Component> getAllChildren();

}
