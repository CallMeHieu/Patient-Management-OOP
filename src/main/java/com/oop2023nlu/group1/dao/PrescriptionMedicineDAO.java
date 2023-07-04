package com.oop2023nlu.group1.dao;

import com.oop2023nlu.group1.model.PrescriptionMedicine;
import com.oop2023nlu.group1.model.Visit;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class PrescriptionMedicineDAO {
    public static PrescriptionMedicine savePrescriptionMedicine(PrescriptionMedicine prescriptionMedicine) {
        Session session = HibernateUtils.getFACTORY().openSession();
        Transaction transaction = null;
        PrescriptionMedicine savedPrescriptionMedicine = null;
        try {
            transaction = session.beginTransaction();
            session.save(prescriptionMedicine);
            session.getTransaction().commit();
            savedPrescriptionMedicine = session.get(PrescriptionMedicine.class, prescriptionMedicine.getId());
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return savedPrescriptionMedicine;

    }

    public static int count() {
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            String hql = "SELECT COUNT(*) FROM PrescriptionMedicine";
            Query<Long> query = session.createQuery(hql, Long.class);
            Long count = query.uniqueResult();
            return count.intValue();
        }
    }

    public static List<PrescriptionMedicine> findAllByVisitId(String idVisit) {
        List<PrescriptionMedicine> prescriptionMedicines = new ArrayList<>();
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            Visit visit = session.get(Visit.class, idVisit);
            prescriptionMedicines = visit.getPrescription();
        }
        return prescriptionMedicines;
    }

    public static boolean isContains(String id) {
        Session session = HibernateUtils.getFACTORY().openSession();
        session.beginTransaction();

        boolean contains= session.createQuery("select count(*) from PrescriptionMedicine where id = :id", Long.class)
                .setParameter("id", id)
                .getSingleResult() > 0;

        session.getTransaction().commit();
        return contains;
    }

    public static void main(String[] args) {
        System.out.println(isContains("6"));
        System.out.println(isContains("10"));
    }
}
