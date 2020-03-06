package by.pvt.helper;

import by.pvt.pojo.Employee;
import by.pvt.pojo.Project;

import java.util.ArrayList;

public class ProjectHelper {

    public static void addEmployee(Project project, Employee employee){
        if (project == null || employee == null) {
            throw new IllegalArgumentException("cannot be null");
        }

        if(project.getEmployees() == null ) {
            project.setEmployees(new ArrayList<>());
        }

        project.getEmployees().add(employee);

        if(employee.getProjects() == null) {
            employee.setProjects(new ArrayList<>());
        }

        employee.getProjects().add(project);

    }

    public static void removeEmployee(Project project, Employee employee){

        if (project == null || employee == null) {
            throw new IllegalArgumentException("cannot be null");
        }

        employee.getProjects().remove(project);

        project.getEmployees().remove(employee);


    }

}
