package by.pvt.pojo;

import by.pvt.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import static org.junit.Assert.fail;

public class EmployeeDetailsTest {

    static EmployeeDetails createTestData(int index) {
        EmployeeDetails employeeDetails = new EmployeeDetails();
        employeeDetails.setLocation("Minsk");
        employeeDetails.setOffice("Office" + index);
        return employeeDetails;
    }

    @Test
    public void testSaveOrUpdate() {
        Transaction tx = null;
        try (Session sess = HibernateUtil.getInstance().getSession()) {
            tx = sess.beginTransaction();

            EmployeeDetails employeeDetails = createTestData(1);
            Employee employee = EmployeeTest.createTestData(1);

            //employee.setEmployeeDetails(employeeDetails);
            employeeDetails.setEmployee(employee);

            sess.saveOrUpdate(employeeDetails);
            sess.saveOrUpdate(employee);

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) tx.rollback();
            fail();
        }

    }

}