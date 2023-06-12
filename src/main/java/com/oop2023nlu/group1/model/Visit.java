package com.oop2023nlu.group1.model;

import com.oop2023nlu.group1.observer.Observer;
import com.oop2023nlu.group1.observer.Subject;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
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
	@OneToOne
	@JoinColumn(name = "prescriptionID")
	private Prescription prescription;// đơn thuốc
	private Date appointmentDate;// ngày hẹn tái khám

	public Visit(String visitID, Date date, String symptom,String conclusion,Prescription prescription) {
		observers = new ArrayList<Observer>();
		this.visitID = visitID;
		this.date = date;
		this.symptom = symptom;
		this.conclusion = conclusion;
		this.prescription = prescription;
	}
	public Visit(String visitID, Date date, String symptom,String conclusion,Prescription prescription,Date appointmentDate) {
		observers = new ArrayList<Observer>();
		this.visitID = visitID;
		this.date = date;
		this.symptom = symptom;
		this.conclusion = conclusion;
		this.prescription = prescription;
		this.appointmentDate = appointmentDate;
	}
	public Visit() {
		observers = new ArrayList<Observer>();
	}
	public Visit(Date date, String symptom,String conclusion,Prescription prescription,Date appointmentDate) {
		observers = new ArrayList<Observer>();
		this.date = date;
		this.symptom = symptom;
		this.conclusion = conclusion;
		this.prescription = prescription;
		this.appointmentDate = appointmentDate;
	}

	public ArrayList<Observer> getObservers() {
		return observers;
	}

	public void setObservers(ArrayList<Observer> observers) {
		this.observers = observers;
		notifyObservers();
	}

	public String getVisitID() {
		return visitID;
	}

	public void setVisitID(String visitID) {
		this.visitID = visitID;
		notifyObservers();
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

	public Prescription getPrescription() {
		return prescription;
	}

	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
		notifyObservers();
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
		notifyObservers();
	}

	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer o) {

	}

	@Override
	public void notifyObservers() {

	}
}
