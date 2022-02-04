package Models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StanowiskoModel {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public ObservableList getAllPlec()
    {

        ObservableList stanowiska;
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            stanowiska = FXCollections.observableArrayList(session.createQuery("from Stanowisko").getResultList());
            transaction.commit();

        } catch (Exception e) {
            stanowiska = null;
            if (transaction != null) {
                transaction.rollback();
            }
        }

        return stanowiska;
    }
}
