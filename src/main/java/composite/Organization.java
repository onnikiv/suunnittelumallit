package composite;

import java.util.ArrayList;

public class Organization extends Component {

    private final ArrayList<Component> children;
    private final String name;

    public Organization(String name) {
        this.children = new ArrayList<>();
        this.name = name;
    }

    @Override
    public void addDepartment(Department department) {
        this.children.add(department);
    }

    @Override
    public void removeDepartment(Department department) {
        children.remove(department);
    }

    @Override
    public void addEmployee(Employee employee) {
        this.children.add(employee);
    }

    @Override
    public void removeEmployee(Employee employee) {
        children.remove(employee);
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
    public ArrayList<Component> getAllChildren() {
        return children;
    }

    public void printOrganizationSalary() {
        System.out.println("Salary summary of the Organization: " + getSalary());
    }

    public void printOrganizationStructure() {
        System.out.println("\n<" + this.getClass().getSimpleName() + " name=\"" + getName() + "\">");

        for (Component child : children) {
            printChildStructure(child, 1);
        }

        System.out.println("</" + this.getClass().getSimpleName() + ">\n");
    }

    private void printChildStructure(Component component, int indent) {
        String indentation = "  ".repeat(indent);

        switch (component) {
            case Employee employee ->
                System.out.println(indentation + "<Employee name=\"" + employee.getName() + "\" salary=\"" + employee.getSalary() + "\"/>");
            case Department department -> {
                System.out.println(indentation + "<Department name=\"" + department.getName() + "\">");

                ArrayList<Component> deptChildren = department.getAllChildren();
                if (department.getAllChildren() != null) {
                    for (Component child : deptChildren) {
                        printChildStructure(child, indent + 1);
                    }
                }

                System.out.println(indentation + "</Department>");
            }
            default -> {
            }
        }
    }
}
