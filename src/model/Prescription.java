package model;

import java.util.ArrayList;
import java.util.List;

import observer.Observer;
import observer.Subject;

public class Prescription implements Subject {// Đơn thuốc
	private ArrayList<Observer> observers;
	private String prescriptionID;
	private List<PrescriptionMedicine> medicines = new ArrayList<PrescriptionMedicine>();

	public Prescription(String prescriptionID) {
		observers = new ArrayList<Observer>();
		this.prescriptionID = prescriptionID;
	}

	public ArrayList<Observer> getObservers() {
		return observers;
	}

	public void setObservers(ArrayList<Observer> observers) {
		this.observers = observers;
		notifyObservers();
	}

	public String getPrescriptionID() {
		return prescriptionID;
	}

	public void setPrescriptionID(String prescriptionID) {
		this.prescriptionID = prescriptionID;
		notifyObservers();
	}

	public List<PrescriptionMedicine> getMedicines() {
		return medicines;
	}

	public void setMedicines(List<PrescriptionMedicine> medicines) {
		this.medicines = medicines;
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
