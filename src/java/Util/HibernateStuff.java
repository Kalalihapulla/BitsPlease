
package Util;

import model.Note;
import org.hibernate.SessionFactory;
import org.hibernate.SessionFactoryObserver;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class HibernateStuff {
    private final SessionFactory sessionFactory;
    
    public HibernateStuff() {
      Configuration config = new Configuration();
    config.addAnnotatedClass(model.Message.class);
     config.addAnnotatedClass(model.Note.class);
     config.addAnnotatedClass(model.UserAccount.class);
     config.addAnnotatedClass(model.AdminAccount.class);
 
     

        config = config.configure();
        
  //new SchemaExport(config).create(true, true);
        
        StandardServiceRegistryBuilder serviceRegistryBuilder = 
                new StandardServiceRegistryBuilder();
        serviceRegistryBuilder.applySettings(config.getProperties());

        ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
        
        config.setSessionFactoryObserver(new SessionFactoryObserver() {
            @Override
            public void sessionFactoryCreated(SessionFactory factory) {}
            @Override
            public void sessionFactoryClosed(SessionFactory factory) {
                System.out.println("sessionFactoryClosed()");
                ((StandardServiceRegistryImpl) serviceRegistry).destroy();
            }
        });
        

        this.sessionFactory = config.buildSessionFactory(serviceRegistry);
    }
    
    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }
    //lul
    public static HibernateStuff getInstance() {
        return HibernateStuffHolder.INSTANCE;
    }
    //Ulu
    //PogChampaaaaaaaaaaaaaaaaasdasdasdasd
    
    private static class HibernateStuffHolder {
        private static final HibernateStuff INSTANCE = new HibernateStuff();
    }
}  
