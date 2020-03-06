package by.pvt.helper;

import by.pvt.pojo.Department;
import by.pvt.pojo.Employee;

import java.util.ArrayList;

public class DepartmentHelper {

    public static void addEmployee(Department department, Employee employee) {
        if (department == null || employee == null)
            throw new IllegalArgumentException("arguments cannot be null");

        if (department.getEmployees() == null)
            department.setEmployees(new ArrayList<>());

        employee.setDepartment(department);
        department.getEmployees().add(employee);
    }

}
