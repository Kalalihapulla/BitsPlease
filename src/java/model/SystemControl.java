/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Util.HibernateStuff;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Izymi
 */
public class SystemControl {

    private SessionFactory sessionFactory;

    private SystemControl() {
    }

    public static SystemControl getInstance() {
        return SystemControlHolder.INSTANCE;
    }

    private static class SystemControlHolder {

        private static final SystemControl INSTANCE = new SystemControl();
    }

    public void addUser(UserAccount user) {
        this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();

        session.saveOrUpdate(user);

        session.getTransaction().commit();

    }

    private class sessionFactory {

        public sessionFactory() {
        }
    }
}
