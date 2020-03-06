package by.pvt.pojo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Test;

import java.util.Date;

import static by.pvt.helper.DepartmentHelper.*;

import static org.junit.Assert.*;

public class DepatmentTest {

    static Employee createEmployee(int index) {
        Employee employee = new Employee();
        employee.setName("Name" + index);
        employee.setEmployeeNumber(index);
        employee.setStartDate(new Date());
        return employee;
    }

    static Depatment createDepatment(long index) {
        Depatment depatment = new Depatment();
        depatment.setLocation("Location_" + index);
        depatment.setName("Department_ " + index);
        return depatment;
    }

    @Test
    public void testSave() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try (SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            Depatment dep1 = createDepatment(1);
            Employee empl1 = createEmployee(1);
            Employee empl2 = createEmployee(2);

            addEpmoyee(dep1, empl1);
            addEpmoyee(dep1, empl2);

            session.save(empl1);
            session.save(empl2);
            session.save(dep1);


            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdate() {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        try {
            Session session = sessionFactory.openSession();

            session.beginTransaction();

            Depatment depatment = createDepatment(1);

            session.save(depatment);
            session.getTransaction().commit();
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Session session = sessionFactory.openSession();

            session.beginTransaction();

            Depatment savedDocument = session.load(Depatment.class, 1);
            assertNotNull(savedDocument);

            savedDocument.setName("New_Name");
            savedDocument.setLocation("New_Location");
            session.update(savedDocument);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}