package dodo.hrms;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dodo.util.HibernateUtil;

public class EmployeeProjectTest {

    static SessionFactory sessionFactory;
    static Session session;

    @BeforeClass
    public static void setup() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Before
    public void beforeMethod() {
        session = sessionFactory.openSession();
    }

    @Test
    public void testEquals() {
        Office off = new Office();
        off.setId(1);
        off.setName("Naresh");

        System.out.println(off.hashCode());

        Office off2 = new Office();
        off2.setId(1);
        off2.setName("Naresh");
        System.out.println(off2.hashCode());

        System.out.println(off.equals(off2));

    }
}
