package com.oop2023nlu.group1.model;

import com.oop2023nlu.group1.observer.Observer;
import com.oop2023nlu.group1.observer.Subject;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "medicine")
public class Medicine implements Subject {// Thuốc
	@Transient
	private ArrayList<Observer> observers;
	@Id
	private String medicineID;
	private String name;
	private String defaultDosage;// liều dùng mặc định
	private String unit;

	public Medicine(String medicineID, String name,String defaultDosage, String unit) {
		observers = new ArrayList<Observer>();
		this.medicineID = medicineID;
		this.name = name;
		this.defaultDosage = defaultDosage;
		this.unit = unit;
	}
	public Medicine() {

	}
	public Medicine( String name,String defaultDosage, String unit) {
		this.name = name;
		this.defaultDosage = defaultDosage;
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

	public String getDefaultDosage() {
		return defaultDosage;
	}

	public void setDefaultDosage(String defaultDosage) {
		this.defaultDosage = defaultDosage;
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
