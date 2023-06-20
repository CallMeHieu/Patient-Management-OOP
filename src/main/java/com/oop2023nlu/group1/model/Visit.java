package com.oop2023nlu.group1.model;

import com.oop2023nlu.group1.dao.VisitDAO;
import com.oop2023nlu.group1.observer.Observer;
import com.oop2023nlu.group1.observer.Subject;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "visit")
public class Visit implements Subject {// Các lần khám bệnh
	@Transient
	private ArrayList<Observer> observers;
	@Id
	private String visitID;
	private Date date;// ngày khám
	private String symptom;// danh sách chuẩn đoán bệnh
	private String conclusion;
	@OneToMany
	@JoinColumn(name = "visitID")
	private List<PrescriptionMedicine> prescription;

	public Visit(String visitID, Date date, String symptom,String conclusion,List<PrescriptionMedicine> prescription) {
		observers = new ArrayList<Observer>();
		this.visitID = visitID;
		this.date = date;
		this.symptom = symptom;
		this.conclusion = conclusion;
		this.prescription = prescription;
	}
	public Visit() {
		observers = new ArrayList<Observer>();
	}
	public Visit(Date date, String symptom,String conclusion,List<PrescriptionMedicine> prescription) {
		observers = new ArrayList<Observer>();
		this.date = date;
		this.symptom = symptom;
		this.conclusion = conclusion;
		this.prescription = prescription;
	}

	//	VISIT MODEL
	public Visit addVisit(Visit visit) {
		return VisitDAO.saveVisit(visit);
	}

	public boolean updateVisit(Visit visit) {
		if(VisitDAO.updateVisit(visit)){
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
		for(Observer o : observers) {
			o.update();
		}
	}
}
