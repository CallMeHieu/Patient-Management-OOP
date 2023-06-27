package com.oop2023nlu.group1.model;

import com.oop2023nlu.group1.dao.VisitDAO;
import com.oop2023nlu.group1.observer.Observer;
import com.oop2023nlu.group1.observer.Subject;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "visit")
public class Visit implements Subject {// Các lần khám bệnh
    public static final Comparator<Visit> DATE_DESCENDING_COMPARATOR = new Comparator<Visit>() {
        @Override
        public int compare(Visit visit1, Visit visit2) {
            return visit2.getDate().compareTo(visit1.getDate());
        }
    };

    @Transient
    private ArrayList<Observer> observers;
    @Id
    private String visitID;
    private Date date;// ngày khám
    private String symptom;// danh sách chuẩn đoán bệnh
    private String conclusion;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "visitID")
    private List<PrescriptionMedicine> prescription;

    public Visit(String visitID, Date date, String symptom, String conclusion, List<PrescriptionMedicine> prescription) {
        observers = new ArrayList<Observer>();
        this.visitID = visitID;
        this.date = date;
        this.symptom = symptom;
        this.conclusion = conclusion;
        this.prescription = prescription;
    }

    public Visit() {
        observers = new ArrayList<>();
    }

    public Visit(Date date, String symptom, String conclusion, List<PrescriptionMedicine> prescription) {
        observers = new ArrayList<>();
        this.date = date;
        this.symptom = symptom;
        this.conclusion = conclusion;
        this.prescription = prescription;
    }

    //	VISIT MODEL
    public Visit addVisit(Visit visit) {
        Visit save = VisitDAO.saveVisit(visit);
        notifyObservers();
        return save;
    }

    public boolean updateVisit(Visit visit) {
        if (VisitDAO.updateVisit(visit)) {
            notifyObservers();
            return true;
        }
        return false;
    }

    public int count() {
        return VisitDAO.count();
    }

    public String getVisitID() {
        return visitID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
        notifyObservers();
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
        notifyObservers();
    }

        public List<Visit> getVisits() {
        List<Visit> visits = VisitDAO.findAllVisit();
        Collections.sort(visits, DATE_DESCENDING_COMPARATOR);
        return visits;
    }

    public List<Visit> getVisitByIdPatient(String idPatient) {
        List<Visit> visits = VisitDAO.findAllVisitByPatient(idPatient);
        Collections.sort(visits, DATE_DESCENDING_COMPARATOR);
        return visits;
    }

    public List<Visit> getVisitByNumberPhone(String numberPhone) {
        List<Visit> visits = VisitDAO.findAllVisitByPatientPhone(numberPhone);
        Collections.sort(visits, DATE_DESCENDING_COMPARATOR);
        return visits;
    }

    public List<PrescriptionMedicine> getPrescription() {
        return prescription;
    }

    public void setPrescription(List<PrescriptionMedicine> prescription) {
        this.prescription = prescription;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visit visit = (Visit) o;
        return Objects.equals(observers, visit.observers) && Objects.equals(visitID, visit.visitID) && Objects.equals(date, visit.date) && Objects.equals(symptom, visit.symptom) && Objects.equals(conclusion, visit.conclusion) && Objects.equals(prescription, visit.prescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(observers, visitID, date, symptom, conclusion, prescription);
    }
}
