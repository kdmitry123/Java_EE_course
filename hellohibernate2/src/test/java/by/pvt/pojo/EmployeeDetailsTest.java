package by.pvt.pojo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Test;

import java.util.Date;


public class EmployeeDetailsTest {

    static EmployeeDetails createTestData(int index) {
        EmployeeDetails employeeDetails = new EmployeeDetails();
        employeeDetails.setLocation("Minsk");
        employeeDetails.setOffice("Office_" + index);
        return employeeDetails;
    }

    static Employee createData(int index) {
        Employee employee = new Employee();
        employee.setName("Name_" + index);
        employee.setEmployeeNumber(index);
        employee.setStartDate(new Date());
        return employee;
    }

    @Test
    public void testSaveOrUpdate() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try (SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            Person person = new Person();
            person.setFirstName("First");
            person.setLastName("Last");
            person.setDateOfBirth(new Date());
            person.setGender('m');

            EmployeeDetails employeeDetails = createTestData(1);

            Employee employee = createData(1);


            employee.setPerson(person);
            person.setEmployee(employee);
            employee.setEmployeeDetails(employeeDetails);
            employeeDetails.setEmployee(employee);

            session.persist(employee);
            session.persist(person);
            session.persist(employeeDetails);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

}