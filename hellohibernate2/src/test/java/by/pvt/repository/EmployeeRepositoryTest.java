package by.pvt.repository;

import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Test;


public class EmployeeRepositoryTest extends DBTestCase {

    StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.test.xml").build();
    SessionFactory testSessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    Session session = testSessionFactory.openSession();


    public EmployeeRepositoryTest(String name) {
        super(name);
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver" );
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://localhost:3306/hello_hibernate_test?createDatabaseIfNotExist=true&useSSL=false" );
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "root" );
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "root" );
    }

    @Test
    public void testFindAll() {


        try {
            session.beginTransaction();

            EmployeeRepository employeeRepository = new EmployeeRepository(session);
            assertNotNull(employeeRepository.findAll());

            session.getTransaction().commit();
            session.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected IDataSet getDataSet() throws Exception {

        return new FlatXmlDataSetBuilder().build(EmployeeRepositoryTest.class.getResourceAsStream("EmployeeRepositoryTest.xml"));

    }
}
