package by.pvt.pojo;

import by.pvt.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.fail;

public class EmployeeTest {

    static Employee createTestData(int index) {
        Employee employee = new Employee();
        employee.setName("Name" + index);
        employee.setEmployeeNumber(index);
        employee.setStartDate(new Date());
        return employee;
    }

    @Test
    public void testSaveOrUpdate() {
        Transaction tx = null;

        try (Session session = HibernateUtil.getInstance().getSession()) {
            tx = session.beginTransaction();

            Employee testEmployee = createTestData(1);
            Person testPerson = PersonTest.createTestData(3);
            testEmployee.setPerson(testPerson);

            session.saveOrUpdate(testPerson);
            session.saveOrUpdate(testEmployee);

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) tx.rollback();
            fail();
        }

    }

}