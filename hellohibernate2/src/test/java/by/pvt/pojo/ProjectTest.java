package by.pvt.pojo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import static by.pvt.helper.ProjectHelper.*;


public class ProjectTest {

    static Project createProject(int index) {
        Project project  = new Project();
        project.setProjectName("Project_" + index);
        project.setStartDate(new Date());

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 12);
        project.setEndDate(calendar.getTime());

        return project;
    }

    static Employee createEmployee(int index) {
        Employee employee = new Employee();
        employee.setName("Name" + index);
        employee.setEmployeeNumber(index);
        employee.setStartDate(new Date());
        return employee;
    }

    @Test
    public void testSave(){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        try {
            Session session = sessionFactory.openSession();

            session.beginTransaction();

            Project project1 = createProject(1);
            Project project2 = createProject(2);

            Employee employee5 = createEmployee(5);
            Employee employee6 = createEmployee(6);
            Employee employee7 = createEmployee(7);

            addEmployee(project1,employee5);
            addEmployee(project1,employee6);

            addEmployee(project2, employee6);
            addEmployee(project2, employee7);

            session.save(project1);
            session.save(project2);

            session.save(employee5);
            session.save(employee6);
            session.save(employee7);

            session.getTransaction().commit();
            session.close();

        }catch (Exception e) {
            e.printStackTrace();

        }

        try {

            Session session = sessionFactory.openSession();

            session.beginTransaction();

            Project savedProject2 = session.load(Project.class, 1L);

            Employee savedEmployee2 = session.load(Employee.class, 1L);

            removeEmployee(savedProject2,savedEmployee2);


            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();

        }



    }


}