package com.oop2023nlu.group1.dao;

import com.oop2023nlu.group1.model.Patient;
import com.oop2023nlu.group1.model.Visit;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PatientDAO {

    public static Patient savePatient(Patient patient) {
        Session session = HibernateUtils.getFACTORY().openSession();
        Transaction transaction = null;
        Patient savedPatient = null;
        try {
            transaction = session.beginTransaction();
            session.save(patient);
            session.getTransaction().commit();
            savedPatient = session.get(Patient.class, patient.getId());
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return savedPatient;
    }

    public static Patient findPatientById(String id) {
        Patient patient = null;
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            patient = session.get(Patient.class, id);
        }
        return patient;
    }

    public static Patient findPatientByPhone(String phone) {
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            String hql = "FROM Patient p WHERE p.phone = :phone";
            Query<Patient> query = session.createQuery(hql, Patient.class);
            query.setParameter("phone", phone);
            return query.uniqueResult();
        }
    }

    public static List<Patient> findAllPatients() {
        List<Patient> patients = new ArrayList<>();
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            patients = session.createQuery("from Patient", Patient.class).getResultList();
        }
        return patients;
    }

    public static boolean deletePatient(String id) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            Patient patient = session.get(Patient.class, id);
            if (patient != null) {
                session.delete(patient);
                transaction.commit();
                return true;
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }

    public static boolean updatePatient(Patient patient) {
        Patient patientInDB = findPatientById(patient.getId());
        if (patientInDB == null) {
            System.out.println("Patient not found");
            return false;
        }else {
            if(patient.getVisits().size() == 0){
                patient.getVisits().addAll(patientInDB.getVisits());
            }
        }

        Transaction transaction = null;
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            System.out.println("p :" + patient.getId() +" size : "+ patient.getVisits().size());
            session.update(patient);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return false;
    }

    public static List<Patient> findAllByCharName(String charName) {
        List<Patient> result = new ArrayList<>();
        for (Patient patient : findAllPatients()) {
            if (patient.getName().toLowerCase().contains(charName.toLowerCase())) {
                result.add(patient);
            }
        }
        return result;
    }

    public static Patient findPatientByVisitId(String idVisit) {
        Visit visit = VisitDAO.findVisitById(idVisit);
        Set<Patient> patients = new HashSet<>(findAllPatients());
        for (Patient patient : patients) {
            for (Visit v : new HashSet<>(VisitDAO.findAllVisitByPatient(patient.getId()))) {
                if (v.getVisitID().equalsIgnoreCase(idVisit)) return patient;
            }
        }
        return null;
    }

}
