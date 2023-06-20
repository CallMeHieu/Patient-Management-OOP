package com.oop2023nlu.group1.dao;
import com.oop2023nlu.group1.model.PrescriptionMedicine;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
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
}
