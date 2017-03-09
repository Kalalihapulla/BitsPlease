package Util;

import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;
import model.AdminAccount;
import model.Note;
import model.Urgency;
import model.UserAccount;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@WebListener
public class StartupListener implements javax.servlet.ServletContextListener {

    private SessionFactory sessionFactory;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("StartupListener contextInitialized()...");
        this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();
        Session session
                = this.sessionFactory.openSession();
        session.beginTransaction();
    
//  Note note1 = new Note("kerk", Urgency.HIGH);
       //session.saveOrUpdate(new UserAccount("jebuulululu@lul.com", "kala"));
//        session.saveOrUpdate(new UserAccount("lulli@lul.com", "rr"));
// 
//        session.saveOrUpdate(new AdminAccount("lulu@ulu.com", "password"));
//          session.saveOrUpdate(new AdminAccount("lulu@ulu.com", "password"));
//        session.saveOrUpdate(new UserAccount());
//      
//       session.saveOrUpdate(new Note());
   
        System.out.println("...contextInitialized() done.");
        session.getTransaction().commit();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("StartupListener contextDestroyed()");
    }
}
