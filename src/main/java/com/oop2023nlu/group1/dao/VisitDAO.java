package com.oop2023nlu.group1.dao;

import com.oop2023nlu.group1.model.Medicine;
import com.oop2023nlu.group1.model.Visit;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class VisitDAO {

    public static Visit saveVisit(Visit visit) {
        Session session = HibernateUtils.getFACTORY().openSession();
        Transaction transaction = null;
        Visit savedVisit = null;
        try {
            transaction = session.beginTransaction();
            session.save(visit);
            session.getTransaction().commit();
            savedVisit = session.get(Visit.class, visit.getVisitID());
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return savedVisit;
    }

    public static boolean updateVisit(Visit visit) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.update(visit);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }

    public static int count() {
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            String hql = "SELECT COUNT(*) FROM Visit";
            Query<Long> query = session.createQuery(hql, Long.class);
            Long count = query.uniqueResult();
            return count.intValue();
        }
    }

    public static List<Visit> findAllVisit() {
        List<Visit> visits = new ArrayList<>();
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            visits = session.createQuery("from Visit", Visit.class).getResultList();
        }
        return visits;
    }
}
