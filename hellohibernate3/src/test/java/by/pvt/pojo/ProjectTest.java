package by.pvt.pojo;

import by.pvt.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static by.pvt.helper.ProjectHelper.addEmployee;
import static by.pvt.helper.ProjectHelper.removeEmployee;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ProjectTest {

    static Project createTestData(int index) {
        Project project = new Project();
        project.setProjectName("Project" + index);

        project.setStartDate(new Date());

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 12);
        project.setEndDate(calendar.getTime());

        return project;
    }

    @Test
    public void testSave() {
        Session session = HibernateUtil.getInstance().getSession();
        Transaction tx = session.beginTransaction();

        Project project1 = createTestData(1);
        Project project2 = createTestData(2);

        Employee employee5 = EmployeeTest.createTestData(5);
        Employee employee6 = EmployeeTest.createTestData(6);
        Employee employee7 = EmployeeTest.createTestData(7);

        addEmployee(project1, employee5);
        addEmployee(project1, employee6);
        addEmployee(project1, employee7);

        addEmployee(project2, employee6);
        addEmployee(project2, employee7);

        session.save(project1);
        session.save(project2);

        session.save(employee5);
        session.save(employee6);
        session.save(employee7);

        tx.commit();
        session.close();

        session = HibernateUtil.getInstance().getSession();
        Project savedProject1 = session.load(Project.class, 1L);
        assertEquals(3, savedProject1.getEmployees().size());
        session.close();

        session = HibernateUtil.getInstance().getSession();
        tx = session.beginTransaction();

        Project savedProject2 = session.get(Project.class, 2L);
        assertNotNull(savedProject2);

        Employee savedEmployee7 = session.get(Employee.class, 7L);
//        assertNotNull(savedEmployee7);

        removeEmployee(savedProject2, savedEmployee7);

        session.update(savedEmployee7);
        session.update(savedProject2);

        tx.commit();
        session.close();

    }

}