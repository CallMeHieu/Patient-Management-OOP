package com.oop2023nlu.group1.model;

import com.oop2023nlu.group1.dao.MedicineDAO;
import com.oop2023nlu.group1.observer.Observer;
import com.oop2023nlu.group1.observer.Subject;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "medicine")
public class Medicine implements Subject{// Thuốc
	@Transient
	private ArrayList<Observer> observers;
	@Id
	private String medicineID;
	private String name;
	private String defaultDosage;// liều dùng mặc định
	private String unit;

	public Medicine(String medicineID, String name, String unit, String defaultDosage) {
		observers = new ArrayList<Observer>();
		this.medicineID = medicineID;
		this.name = name;
		this.unit = unit;
		this.defaultDosage = defaultDosage;
	}
	public Medicine() {
		this.observers = new ArrayList<>();
	}
	public Medicine( String name, String unit,String defaultDosage) {
		this.name = name;
		this.unit = unit;
		this.defaultDosage = defaultDosage;
	}
	public void addMedicine(Medicine medicine) {
		MedicineDAO.saveMedicine(medicine);
		notifyObservers();
	}

	public Medicine findMedicineById(String id) {
		return MedicineDAO.findMedicineById(id);
	}
	public List<Medicine> getMedicines() {
		return MedicineDAO.findAllMedicines();
	}
	public List<Medicine> findAllByCharName(String name) {
		return MedicineDAO.findAllByCharName(name);
	}

	public boolean updateMedicine(Medicine medicine) {
		if(MedicineDAO.updateMedicine(medicine)){
			notifyObservers();
			return true;
		}
		return false;
	}

	public boolean deleteMedicine(String id) {
		if(MedicineDAO.deleteMedicine(id)){
			notifyObservers();
			return true;
		}
		return false;
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
}
