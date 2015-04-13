package infrastructure.hibernate;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import core.entities.Book;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();
      
    private static SessionFactory buildSessionFactory(){
        try {
        	Configuration configuration = new Configuration();
        	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
        			configuration.getProperties()).build();
        	configuration.addAnnotatedClass(Book.class);
            SessionFactory session = configuration.buildSessionFactory(serviceRegistry);
            return session;
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
  
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
  
    public static void shutdown() {
        getSessionFactory().close();
    }
}