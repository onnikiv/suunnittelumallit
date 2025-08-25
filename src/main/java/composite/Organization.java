package composite;

import java.util.ArrayList;

public class Organization {

    ArrayList<Object> children;

    public Organization() {
        this.children = new ArrayList<>();

    }

    public void addDepartment(Department department) {
        this.children.add(department);

    }

    public void addEmployee(Employee employee) {
        this.children.add(employee);
    }

    public void printSalaryOfOrganization() {

        double salary = 0;

        for (Object obj : children) {
            if (obj instanceof Employee employee) {
                // System.out.println(employee.getName() + " - " + employee.getSalary());
                salary += employee.getSalary();
            }

            if (obj instanceof Department department) {
                department.getSalaryOfDepartment();
                salary += department.getSalaryOfDepartment();
            }
        }
        System.out.println("The whole salary of the Organization: " + salary + " $");
    }

    public void printOrganizationStructure() {

        for (Object obj : children) {
            if (obj instanceof Employee employee) {
                System.out.println(employee.getName());
            }

            if (obj instanceof Department department) {
                System.out.println(department.getDepartmentName());
                for (Employee employee : department.employees) {
                    System.out.println(employee.getName());
                }
            }
        }
    }
}
