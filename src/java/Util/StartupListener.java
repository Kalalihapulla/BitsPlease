package Util;

import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * The listener event for the new sessions
 * 
 */
@WebListener
public class StartupListener implements javax.servlet.ServletContextListener {

    private SessionFactory sessionFactory;

    /**
     * Opens up the hibernate transaction
     * @param sce 
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("StartupListener contextInitialized()...");
        this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();
        Session session
                = this.sessionFactory.openSession();
        session.beginTransaction();
        System.out.println("...contextInitialized() done.");
        session.getTransaction().commit();
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("StartupListener contextDestroyed()");
    }
}
