package composite;

import java.util.ArrayList;

public class Department {

    private final String name;
    ArrayList<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();

    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public String getDepartmentName() {
        return this.name;
    }

    public double getEmployeeSalary(Employee employee) {
        return employee.getSalary();
    }

    public double getSalaryOfDepartment() {
        double departmentSalary = 0;

        for (Employee employee : employees) {
            departmentSalary += employee.getSalary();

        }

        return departmentSalary;
    }

}
