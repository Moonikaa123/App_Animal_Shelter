package Models;

import Entities.Koszty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;

public class KosztyModel {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public ObservableList getAllKoszty()
    {

        ObservableList koszty;
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            koszty = FXCollections.observableArrayList(session.createQuery("from Koszty").getResultList());
            transaction.commit();

        } catch (Exception e) {
            koszty = null;
            if (transaction != null) {
                transaction.rollback();
            }
        }

        return koszty;
    }

    public void createKosztyWydatki(Koszty koszty)
    {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(koszty);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public void aktualizujKosztyWydatki(Koszty koszty)
    {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(koszty);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }


    public void usunKosztyWydatki(int id)
    {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            String hql = "DELETE FROM Koszty WHERE id = :id";
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
