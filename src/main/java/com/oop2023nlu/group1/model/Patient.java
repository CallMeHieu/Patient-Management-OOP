package com.oop2023nlu.group1.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "patient")
public class Patient {// bệnh nhân
	@Id
	@Column(name = "patientID")
	private String id;
	private String name;
	private String address;
	private String phone;
	private int yearOfBirth;
	private boolean gender;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "patientID")
	private List<Visit> visits = new ArrayList<>();

	public Patient(String id, String name, String address, String phone, int yearOfBirth, boolean gender) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.yearOfBirth = yearOfBirth;
		this.gender = gender;
	}

	public Patient() {
	}

	public Patient(String id, String name, String address, String phone, int yearOfBirth, boolean gender, List<Visit> visits) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.yearOfBirth = yearOfBirth;
		this.gender = gender;
		this.visits = visits;
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
