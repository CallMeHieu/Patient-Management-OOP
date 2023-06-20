package com.oop2023nlu.group1.model;

import com.oop2023nlu.group1.dao.PrescriptionMedicineDAO;
import com.oop2023nlu.group1.observer.Observer;
import com.oop2023nlu.group1.observer.Subject;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "prescription_medicine")
public class PrescriptionMedicine implements Subject {
	@Transient
	private ArrayList<Observer> observers;
	@Id
	private String id;// id mặc định
	@ManyToOne
	@JoinColumn(name = "medicineID")
	private Medicine medicine;
	private String dosage;// liều dùng
	private int quantity;// số lượng trong đơn

	public PrescriptionMedicine(String id, Medicine medicine, String dosage, int quantity) {
		this.id = id;
		this.medicine = medicine;
		this.dosage = dosage;
		this.quantity = quantity;
	}

	public PrescriptionMedicine() {
		this.observers = new ArrayList<>();
	}

	public PrescriptionMedicine(Medicine medicine, String dosage, int quantity) {
		this.medicine = medicine;
		this.dosage = dosage;
		this.quantity = quantity;
	}

	public int count() {
		return PrescriptionMedicineDAO.count();
	}

	public PrescriptionMedicine addPrescriptionMedicine(PrescriptionMedicine prescriptionMedicine) {
		return PrescriptionMedicineDAO.savePrescriptionMedicine(prescriptionMedicine);
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


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Medicine getMedicine() {
		return medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String toString(){
		return " - " + this.medicine.getMedicineID() + ", " + this.medicine.getName() + "(" + this.dosage +")"+ "SL: " + this.quantity + "\n";
	}

}
