package dodo.hrms;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dodo.util.HibernateUtil;

public class OrderTest {

    SessionFactory sessionFactory;
    Session session;

    @BeforeClass
    public void setup() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }
    
    @BeforeMethod
    public void beforeMethod() {
        session = sessionFactory.openSession();
    }

    @Test
    public void createOrder() {

    }

}
