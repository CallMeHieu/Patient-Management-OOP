package model;

import java.util.ArrayList;

import observer.Observer;
import observer.Subject;

public class Medicine implements Subject {// Thuốc
	private ArrayList<Observer> observers;
	private String medicineID;
	private String name;
	private String unit; // liều dùng mặc định

	public Medicine(String medicineID, String name, String unit) {
		observers = new ArrayList<Observer>();
		this.medicineID = medicineID;
		this.name = name;
		this.unit = unit;
	}

	public ArrayList<Observer> getObservers() {
		return observers;
	}

	public void setObservers(ArrayList<Observer> observers) {
		this.observers = observers;
		notifyObservers();
	}

	public String getMedicineID() {
		return medicineID;
	}

	public void setMedicineID(String medicineID) {
		this.medicineID = medicineID;
		notifyObservers();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		notifyObservers();
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
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

	}


}
