package by.pvt.pojo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static by.pvt.util.HibernateUtil.getInstance;
import static org.junit.Assert.assertEquals;

/**
 * @author alve
 */
public class PersonTest {


    static Person createTestData(int i) {
        Person person = new Person();
        person.setId(i);
        person.setFirstName("FirstName" + i);
        person.setLastName("LastName" + i);
        person.setDateOfBirth(new Date());
        person.setGender('a');
        return person;
    }

    @Test
    public void testSavePerson() { // PersonDao.save(person)
        Session session = getInstance().getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Person p = createTestData(1);
            session.saveOrUpdate(p);
            tx.commit();

            tx = session.beginTransaction();
            Person p_2 = createTestData(2);
            session.saveOrUpdate(p_2);
            tx.commit();
            session.close();

            session = getInstance().getSession();
            tx = session.beginTransaction();
            List<Person> personList =
                    session
                            .createQuery("from Person", Person.class)
                            .list();
            assertEquals(2, personList.size());
            Person p2 = personList.get(0);
//            assertEquals(p, p2);
            tx.commit();
            session.close();


            /*session = getInstance().getSession();
            tx = session.beginTransaction();
            Person loadedPerson = session.get(Person.class, 1);
            assertEquals(p.getId(), loadedPerson.getId());
            assertEquals(p, loadedPerson);
            tx.commit();*/

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }


    }

    @Test
    public void testDeletePerson() {

    }


}