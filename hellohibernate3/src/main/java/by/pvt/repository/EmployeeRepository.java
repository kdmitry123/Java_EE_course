package by.pvt.repository;

import by.pvt.pojo.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeRepository {

    private Session session;

    public EmployeeRepository(Session session) {
        this.session = session;
    }

    public List<Employee> findAll() {
        return session
                .createQuery("from Employee", Employee.class)
                .list();
    }

    public Double findSalarySum() {
        return session
                .createQuery("select sum(E.salary) from Employee E", Double.class)
                .getSingleResult();
    }

    public Integer findEmployeeCount() {
        return session
                .createQuery("select count(E.id) from Employee E", Integer.class)
                .getSingleResult();
    }

    public List<Employee> findEmployeeByOffice(String officeName) {

       Query<Employee> query =  session.createQuery("select E from Employee E" +
               " WHERE E.employeeDetails.office like :officeName", Employee.class);
       query.setParameter("officeName", officeName);
       return query.list();
    }
}
