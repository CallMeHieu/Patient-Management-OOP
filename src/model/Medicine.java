package model;

public class Medicine {// Thuốc
	private String medicineID;
	private String name;
	private String dosage;// liều dùng
	private String unit; // đơn vị

	public Medicine(String medicineID, String name, String unit, String dosage) {
		super();
		this.medicineID = medicineID;
		this.name = name;
		this.dosage = dosage;
		this.unit = unit;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public String getMedicineID() {
		return medicineID;
	}

	public void setMedicineID(String medicineID) {
		this.medicineID = medicineID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}
