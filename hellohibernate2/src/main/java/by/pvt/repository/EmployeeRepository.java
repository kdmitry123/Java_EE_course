package by.pvt.repository;

import by.pvt.pojo.Employee;
import lombok.AllArgsConstructor;
import org.hibernate.Session;

import java.util.List;

@AllArgsConstructor
public class EmployeeRepository {

    private Session session;

    public List<Employee> findAll(){

        return session.createQuery("from employee", Employee.class).list();

    }


}
