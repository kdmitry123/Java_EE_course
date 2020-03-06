package by.pvt.helper;

import by.pvt.pojo.*;

import java.util.ArrayList;

public class DepartmentHelper {


    public static void addEpmoyee(Depatment department,  Employee employee){
        if (department == null || employee == null)
            throw new IllegalArgumentException("argument cannot be null");

        if (department.getEmployees() == null) department.setEmployees(new ArrayList<>());

        employee.setDepatment(department);
        department.getEmployees().add(employee);


    }


}
