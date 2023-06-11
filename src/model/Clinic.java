package model;

import java.util.ArrayList;
import java.util.List;

import data.MedicineDAO;
import data.PatientDAO;
import observer.Observer;
import observer.Subject;

public class Clinic implements Subject { // Phòng khám
	private ArrayList<Observer> observers;
	private String name;
	private String address;
	private String phone;
	private List<Patient> patients = new ArrayList<>();
	private List<Medicine> medicines = new ArrayList<>();

	public Clinic(String name, String address, String phone, List<Patient> patients, List<Medicine> medicines) {
		observers = new ArrayList<>();
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.patients = patients;
		this.medicines = medicines;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
		notifyObservers();
	}

	public List<Medicine> getMedicines() {
		return medicines;
	}

	public void setMedicines(List<Medicine> medicines) {
		this.medicines = medicines;
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

	public void addPatient(Patient patient) {
		PatientDAO.savePatient(patient);
		this.patients = PatientDAO.patients;
		notifyObservers();
	}

	public Patient findPatientById(String id) {
		return PatientDAO.findPatientById(id);
	}

	public boolean deletePatient(String id) {
		if (PatientDAO.deletePatient(id)) {
			this.patients = PatientDAO.patients;
			notifyObservers();
			return true;
		}
		return false;
	}

	public boolean updatePatient(Patient patient) {
		if (PatientDAO.updatePatient(patient)) {
			this.patients = PatientDAO.patients;
			notifyObservers();
			return true;
		}
		return false;
	}

	public void addMedicine(Medicine medicine) {
		MedicineDAO.saveMedicine(medicine);
		this.medicines = MedicineDAO.medicines;
		notifyObservers();
	}

	public Medicine findMedicineById(String id) {
		return MedicineDAO.findMedicineById(id);
	}

	public boolean deleteMedicine(String id) {
		if (MedicineDAO.deleteMedicine(id)) {
			this.medicines = MedicineDAO.medicines;
			notifyObservers();
			return true;
		}
		return false;
	}

	public boolean updateMedicine(Medicine medicine) {
		if (MedicineDAO.updateMedicine(medicine)) {
			this.medicines = MedicineDAO.medicines;
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
		for (Observer o : observers) {
			o.update();
		}
	}
}
