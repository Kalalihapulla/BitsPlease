///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Util;
//
//import javax.servlet.ServletContextEvent;
//import model.Admin;
//import model.UserAccount;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//
///**
// *
// * @author Izymi
// */
//public class TestListener implements javax.servlet.ServletContextListener {
//
//    private SessionFactory sessionFactory;
//
//    @Override
//    public void contextInitialized(ServletContextEvent sce) {
//        this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();
//        Session session
//                = this.sessionFactory.openSession();
//        Transaction t = session.beginTransaction();
//
//        session.saveOrUpdate(new UserAccount("jebu@lulli.com", "kala"));
//        session.saveOrUpdate(new Admin("hello@google.com", "kappa"));
//        t.commit();
//        session.close();
//    }
//
//    @Override
//    public void contextDestroyed(ServletContextEvent sce) {
//        System.out.println("StartupListener contextDestroyed()");
//    }
//}
