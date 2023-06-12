package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

import data.PatientDAO;
import model.Clinic;
import model.Patient;
import model.Visit;
import view.container.Container;

public class PatientController {
	private Container view;
	private Clinic model;

	public PatientController(Container view, Clinic model) {
		super();
		this.view = view;
		this.model = model;
		initViewListeners();
		model.registerObserver(view.getPatientPanel().getPnSubBenhNhan());
		view.getPatientPanel().getPnSubBenhNhan().setClinic(model);
		model.notifyObservers();
	}

	private void initViewListeners() {
		addPatient();
		updatePatient();
		deletePatient();
		searchPatient();
	}

	private void addPatient() {
		this.view.getPatientPanel().getPnSubBenhNhan().getBtnAdd().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (view.getPatientPanel().getPnSubBenhNhan().getTfId().getText().equals("")) {
					String id = "";
					if (model.getPatients() == null) {
						id = "001";
					} else
						id = "00" + (model.getPatients().size() + 1);
					String name = view.getPatientPanel().getPnSubBenhNhan().getTfName().getText();
					String address = view.getPatientPanel().getPnSubBenhNhan().getTfAddress().getText();
					String phone = view.getPatientPanel().getPnSubBenhNhan().getTfPhone().getText();
					int yearOfBirth = Integer
							.parseInt(view.getPatientPanel().getPnSubBenhNhan().getTfYearOfBirth().getText());
					String gender = view.getPatientPanel().getPnSubBenhNhan().getCbbGender().getSelectedItem() + "";
					Patient patient = new Patient(id, name, address, phone, yearOfBirth, true);
					if (gender.equalsIgnoreCase("Nữ")) {
						patient = new Patient(id, name, address, phone, yearOfBirth, false);
					}
					List<Visit> visits = new ArrayList<>();
					patient.setVisits(visits);
					model.addPatient(patient);
					JOptionPane.showMessageDialog(null, "Thêm thành công");
				} else {
					resetForm();
				}
			}
		});
	}

	private void updatePatient() {
		this.view.getPatientPanel().getPnSubBenhNhan().getBtnEdit().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = view.getPatientPanel().getPnSubBenhNhan().getTfId().getText();
				if (model.findPatientById(id) != null) {
					String name = view.getPatientPanel().getPnSubBenhNhan().getTfName().getText();
					String address = view.getPatientPanel().getPnSubBenhNhan().getTfAddress().getText();
					String phone = view.getPatientPanel().getPnSubBenhNhan().getTfPhone().getText();
					int yearOfBirth = Integer
							.parseInt(view.getPatientPanel().getPnSubBenhNhan().getTfYearOfBirth().getText());
					String gender = view.getPatientPanel().getPnSubBenhNhan().getCbbGender().getSelectedItem() + "";

					Patient patient = new Patient(id, name, address, phone, yearOfBirth, true);
					if (gender.equalsIgnoreCase("Nữ"))
						patient = new Patient(id, name, address, phone, yearOfBirth, false);

					if (model.updatePatient(patient))
						JOptionPane.showMessageDialog(null, "Cập nhật thành công");
					else
						JOptionPane.showMessageDialog(null, "Cập nhật thất bại!!!");
				} else {
					JOptionPane.showMessageDialog(null, "Lỗi !!! Không tìm thấy bệnh nhân này");
				}
			}
		});
	}

	private void deletePatient() {
		this.view.getPatientPanel().getPnSubBenhNhan().getBtnRemove().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Bạn có chắc là xóa bệnh nhân này", "Xác nhận",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (result == JOptionPane.YES_OPTION) {
					String id = view.getPatientPanel().getPnSubBenhNhan().getTfId().getText();
					if (model.deletePatient(id))
						JOptionPane.showMessageDialog(null, "Xóa thành công");
					else
						JOptionPane.showMessageDialog(null, "Xóa thất bại!!!");
				} else if (result == JOptionPane.NO_OPTION) {
					System.out.println("Bạn chọn không");
				} else {
					System.out.println("...");
				}
			}
		});
	}

	private void searchPatient() {
		this.view.getPatientPanel().getPnSubBenhNhan().getTfSearch().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String charName = view.getPatientPanel().getPnSubBenhNhan().getTfSearch().getText();
				List<Patient> patients = PatientDAO.findAllByCharName(charName);
				view.getPatientPanel().getPnSubBenhNhan().getDtmPatient().setRowCount(0);
				for (Patient patient : patients) {
					Vector<Object> vec = new Vector<>();
					vec.add(patient.getId());
					vec.add(patient.getName());
					vec.add(patient.getYearOfBirth());
					if (patient.isGender()) {
						vec.add("Nam");
					} else
						vec.add("Nữ");
					vec.add(patient.getPhone());
					vec.add(patient.getAddress());
					view.getPatientPanel().getPnSubBenhNhan().getDtmPatient().addRow(vec);
				}
			}
		});
	}

	private void resetForm() {
		view.getPatientPanel().getPnSubBenhNhan().getTfId().setText("");
		view.getPatientPanel().getPnSubBenhNhan().getTfName().setText("");
		view.getPatientPanel().getPnSubBenhNhan().getTfPhone().setText("");
		view.getPatientPanel().getPnSubBenhNhan().getTfYearOfBirth().setText("");
		view.getPatientPanel().getPnSubBenhNhan().getTfAddress().setText("");
	}

}
