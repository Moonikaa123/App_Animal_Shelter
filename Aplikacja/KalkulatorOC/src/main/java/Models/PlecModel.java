package Models;

import Entities.Koszty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;

public class PlecModel {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public ObservableList getAllPlec()
    {

        ObservableList plcie;
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            plcie = FXCollections.observableArrayList(session.createQuery("from Plec").getResultList());
            transaction.commit();

        } catch (Exception e) {
            plcie = null;
            if (transaction != null) {
                transaction.rollback();
            }
        }

        return plcie;
    }
}
