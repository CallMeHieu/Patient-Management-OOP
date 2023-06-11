package model;

import java.util.ArrayList;
import java.util.Date;

import observer.Observer;
import observer.Subject;

public class Visit implements Subject {// Các lần khám bệnh
	private ArrayList<Observer> observers;
	private String visitID;
	private Date date;// ngày khám
	private String symptom;// danh sách chuẩn đoán bệnh
	private String conclusion;// kết quả
	private Prescription prescription;// đơn thuốc

	public Visit(String visitID, Date date, String symptom, String conclusion, Prescription prescription) {
		observers = new ArrayList<Observer>();
		this.visitID = visitID;
		this.date = date;
		this.symptom = symptom;
		this.conclusion = conclusion;
		this.prescription = prescription;
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
