package Models;

import Entities.Zwierze;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;

public class ZwierzeModel {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public ObservableList getAllAnimals()
    {

        ObservableList zwierze;
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            zwierze = FXCollections.observableArrayList(session.createQuery("from Zwierze").getResultList());
            transaction.commit();

        } catch (Exception e) {
            zwierze = null;
            if (transaction != null) {
                transaction.rollback();
            }
        }

        return zwierze;
    }

    public void createZwierze(Zwierze zwierze)
    {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(zwierze);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public void aktualizujZwierze(Zwierze zwierze)
    {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(zwierze);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }


    public void usunZwierze(int id)
    {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            String hql = "DELETE FROM Zwierze WHERE id = :id";
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
