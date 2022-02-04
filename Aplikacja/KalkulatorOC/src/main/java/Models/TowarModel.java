package Models;

import Entities.Towar;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;

public class TowarModel {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public ObservableList getAllTowar()
    {

        ObservableList towar;
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            towar = FXCollections.observableArrayList(session.createQuery("from Towar").getResultList());
            transaction.commit();

        } catch (Exception e) {
            towar = null;
            if (transaction != null) {
                transaction.rollback();
            }
        }

        return towar;
    }

    public void createTowar(Towar towar)
    {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(towar);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public void aktualizujTowar(Towar towar)
    {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(towar);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }


    public void usunTowar(int id)
    {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            String hql = "DELETE FROM Towar WHERE id = :id";
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