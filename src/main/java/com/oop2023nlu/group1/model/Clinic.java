package com.oop2023nlu.group1.model;

import com.oop2023nlu.group1.dao.PatientDAO;
import com.oop2023nlu.group1.dao.MedicineDAO;
import com.oop2023nlu.group1.observer.Observer;
import com.oop2023nlu.group1.observer.Subject;

import java.util.ArrayList;
import java.util.List;

public class Clinic implements Subject { // Phòng khám
	private ArrayList<Observer> observers;
	private String name;
	private String address;
	private String phone;


	public Clinic(String name, String address, String phone) {
		observers = new ArrayList<>();
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	public List<Medicine> getMedicines() {
		return MedicineDAO.findAllMedicines();
	}
	public List<Patient> getPatients() {
		return PatientDAO.findAllPatients();
	}

	public ArrayList<Observer> getObservers() {
		return observers;
	}

	public void setObservers(ArrayList<Observer> observers) {
		this.observers = observers;
		notifyObservers();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		notifyObservers();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
		notifyObservers();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
		notifyObservers();
	}


//	PATIENT MODEL
	public void addPatient(Patient patient) {
		PatientDAO.savePatient(patient);
		notifyObservers();
	}

	public Patient findPatientById(String id) {
		return PatientDAO.findPatientById(id);
	}

	public boolean deletePatient(String id) {
		if(PatientDAO.deletePatient(id)){
			notifyObservers();
			return true;
		}
		return false;
	}
	public boolean updatePatient(Patient patient) {
		if(PatientDAO.updatePatient(patient)){
			notifyObservers();
			return true;
		}
		return false;
	}

//MEDICINE MODEL
	public void addMedicine(Medicine medicine) {
		MedicineDAO.saveMedicine(medicine);
		notifyObservers();
	}

	public Medicine findMedicineById(String id) {
		return MedicineDAO.findMedicineById(id);
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
	public void registerObserver(Observer o) {
		observers.add(o);
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
