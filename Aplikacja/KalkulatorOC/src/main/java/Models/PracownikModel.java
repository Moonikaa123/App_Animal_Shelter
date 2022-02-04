package Models;


import controller.HelperPracownik;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Entities.*;

import javax.persistence.Query;

public class PracownikModel {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public ObservableList getAllUsers()
    {

        ObservableList pracownicy;
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            pracownicy = FXCollections.observableArrayList(session.createQuery("from Pracownik").getResultList());
            transaction.commit();

        } catch (Exception e) {
            pracownicy = null;
            if (transaction != null) {
                transaction.rollback();
            }
        }

        return pracownicy;
    }

    public void createPracownik(Pracownik pracownik)
    {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(pracownik);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public void aktualizujPracownik(Pracownik pracownik)
    {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(pracownik);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }


    public void usunPracownik(int id)
    {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            String hql = "DELETE FROM Pracownik WHERE id = :id";
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
