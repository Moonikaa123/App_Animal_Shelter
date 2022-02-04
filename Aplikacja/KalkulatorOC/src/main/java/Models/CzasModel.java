package Models;

import Entities.Czas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;

public class CzasModel {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public ObservableList getAllCzas()
    {

        ObservableList czas;
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            czas = FXCollections.observableArrayList(session.createQuery("from Czas").getResultList());
            transaction.commit();

        } catch (Exception e) {
            czas = null;
            if (transaction != null) {
                transaction.rollback();
            }
        }

        return czas;
    }

    public void createCzas(Czas czas)
    {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(czas);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public void aktualizujCzas(Czas czas)
    {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(czas);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public void usunCzas(int id)
    {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            String hql = "DELETE FROM Czas WHERE id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id",id);
            int result = query.executeUpdate();
            System.out.println("Rows affected: " + result);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}