package by.pvt.pojo;

import by.pvt.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import static by.pvt.helper.DepartmentHelper.addEmployee;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class DepartmentTest {

    static Department createTestData(int index) {
        Department department = new Department();
        department.setLocation("Location" + index);
        department.setName("Department" + index);
        return department;
    }

    @Test
    public void testSave() {
        Transaction tx = null;
        Session session = HibernateUtil.getInstance().getSession();
        try {
            tx = session.beginTransaction();
            Department dep1 = createTestData(1);

            Employee empl1 = EmployeeTest.createTestData(1);
            Employee empl2 = EmployeeTest.createTestData(2);

            addEmployee(dep1, empl1);
            addEmployee(dep1, empl2);

            session.save(empl1);
            session.save(empl2);
            session.save(dep1);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) tx.rollback();
            fail();
        }
        session.close();
    }

    @Test
    public void testUpdate() {
        Session session = HibernateUtil.getInstance().getSession();
        Transaction tx = session.beginTransaction();
        Department department = createTestData(1);
        session.save(department);
        tx.commit();
        session.close();

        session = HibernateUtil.getInstance().getSession();
        tx = session.beginTransaction();
        try {
            Department savedDocument = session.load(Department.class, 1L);
            assertNotNull(savedDocument);
            savedDocument.setName("New Name");
            savedDocument.setLocation("New Location");
            session.update(savedDocument);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) tx.rollback();
            fail();
        }

    }

    public boolean save(Department department) {
        return true;
    }

    public void save2(Department department) {
    }

}