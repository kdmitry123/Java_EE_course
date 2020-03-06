package by.pvt.repository;

import by.pvt.pojo.Employee;
import by.pvt.util.HibernateUtil;
import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;

public class EmployeeRepositoryTest extends DBTestCase {

    private Session session = HibernateUtil.getInstance().getTestSession();

    public EmployeeRepositoryTest(String name) {
        super(name);
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS,
                "com.mysql.jdbc.Driver");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL,
                "jdbc:mysql://localhost:3306/hello_hibernate_test?createDatabaseIfNotExist=true&useSSL=false");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "root");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "root");
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSetBuilder().build(
                EmployeeRepositoryTest.class.getResourceAsStream("EmployeeRepositoryTest.xml")
        );
    }

    @Test
    public void testFindAll() {
        EmployeeRepository employeeRepository
                = new EmployeeRepository(session);

        assertNotNull(employeeRepository.findAll());
    }

    @Test
    public void testFindSalarySum() {
        EmployeeRepository employeeRepository
                = new EmployeeRepository(session);
        Double sumSalary = employeeRepository.findSalarySum();
        assertEquals(2150d, sumSalary);
    }

    @Test
    public void testFindEmployeeByOffice(){
        EmployeeRepository employeeRepository = new EmployeeRepository(session);
        String officeName1 = "Minsk";

        List<Employee> employee1 = employeeRepository.findEmployeeByOffice(officeName1);
        assertNotNull(employee1);
        assertEquals(0, employee1.size());
    }
}