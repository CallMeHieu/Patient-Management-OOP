package com.oop2023nlu.group1.model;

import com.oop2023nlu.group1.dao.PatientDAO;
import com.oop2023nlu.group1.dao.MedicineDAO;
import com.oop2023nlu.group1.dao.VisitDAO;
import com.oop2023nlu.group1.observer.Observer;
import com.oop2023nlu.group1.observer.Subject;

import java.util.ArrayList;
import java.util.List;

public class Clinic implements Subject{ // Phòng khám
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

	public Clinic() {
		this.observers = new ArrayList<>();
	}

//	public List<Medicine> getMedicines() {
//		return MedicineDAO.findAllMedicines();
//	}
//	public List<Patient> getPatients() {
//		return PatientDAO.findAllPatients();
//	}

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


//	PATIENT MODEL
	/*
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
*/

//MEDICINE MODEL
	/*
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
*/

//	VISIT MODEL
	/*
	public void addVisit(Visit visit) {
		VisitDAO.saveVisit(visit);
		notifyObservers();
	}

	public boolean updateVisit(Visit visit) {
		if(VisitDAO.updateVisit(visit)){
			notifyObservers();
			return true;
		}
		return false;
	}
*/

}
