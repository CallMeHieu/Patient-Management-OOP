package com.oop2023nlu.group1.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "prescription_medicine")
public class PrescriptionMedicine {
	@Id
	private String id;// id mặc định
	@OneToOne
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
	}

	public PrescriptionMedicine(Medicine medicine, String dosage, int quantity) {
		this.medicine = medicine;
		this.dosage = dosage;
		this.quantity = quantity;
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

}
