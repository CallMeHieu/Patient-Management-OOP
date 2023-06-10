package model;

import java.util.ArrayList;
import java.util.List;

public class Patient {// bệnh nhân
	private String id;
	private String name;
	private String address;
	private String phone;
	private int yearOfBirth;
	private boolean gender;
	private List<Visit> visits = new ArrayList<>();

	public Patient(String id, String name, String address, String phone, int yearOfBirth, boolean gender) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.yearOfBirth = yearOfBirth;
		this.gender = gender;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public List<Visit> getVisits() {
		return visits;
	}

	public void setVisits(List<Visit> visits) {
		this.visits = visits;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + ", yearOfBirth=";
	}
}
