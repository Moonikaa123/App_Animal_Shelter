package Models;
import Entities.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {
    private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory() {
        try {

            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Entities.Pracownik.class);
            configuration.addAnnotatedClass(Entities.Zwierze.class);
            configuration.addAnnotatedClass(Entities.Koszty.class);
            configuration.addAnnotatedClass(Entities.Towar.class);
            configuration.addAnnotatedClass(Entities.Czas.class);

            configuration.addAnnotatedClass(Entities.Plec.class);
            configuration.addAnnotatedClass(Entities.Stanowisko.class);

            configuration.configure("hibernate.cfg.xml");

            System.out.println("Hibernate Annotation Configuration loaded");

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
                    .build();
            System.out.println("Hibernate Annotation serviceRegistry created");

            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            return sessionFactory;
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null)
            sessionFactory = buildSessionFactory();
        return sessionFactory;
    }
}