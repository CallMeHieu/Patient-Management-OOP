package com.oop2023nlu.group1.controller;

import com.oop2023nlu.group1.dao.PatientDAO;
import com.oop2023nlu.group1.model.*;
import com.oop2023nlu.group1.view.container.Container;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

public class PatientController {
    private Container view;
    private Patient patientModel;

    public PatientController(Container view, Patient patientModel) {
        this.view = view;
        initViewListeners();
        this.patientModel = patientModel;
        this.patientModel.registerObserver(view.getPatientPanel().getPnSubPatient());
        this.view.getPatientPanel().getPnSubPatient().setModel(patientModel);
        this.patientModel.notifyObservers();
    }

    private void initViewListeners() {
        addPatient();
        updatePatient();
        deletePatient();
        searchPatient();
    }

    private void addPatient() {
        this.view.getPatientPanel().getPnSubPatient().getBtnAdd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getPatientPanel().getPnSubPatient().getTfId().getText().equals("")) {
                    String id = "";
                    if (patientModel.getPatients() == null) {
                        id = "001";
                    } else
                        id = "00" + (patientModel.getPatients().size() + 1);
                    String name = view.getPatientPanel().getPnSubPatient().getTfName().getText();
                    String address = view.getPatientPanel().getPnSubPatient().getTfAddress().getText();
                    String phone = view.getPatientPanel().getPnSubPatient().getTfPhone().getText();
                    int yearOfBirth = Integer
                            .parseInt(view.getPatientPanel().getPnSubPatient().getTfYearOfBirth().getText());
                    String gender = view.getPatientPanel().getPnSubPatient().getCbbGender().getSelectedItem() + "";
                    Patient patient = new Patient(id, name, address, phone, yearOfBirth, true);
                    if (gender.equalsIgnoreCase("Nữ")) {
                        patient = new Patient(id, name, address, phone, yearOfBirth, false);
                    }
                    List<Visit> visits = new ArrayList<>();
                    patient.setVisits(visits);
                    patientModel.addPatient(patient);
                    resetForm();
                    JOptionPane.showMessageDialog(null, "Thêm thành công");
                } else {
                    resetForm();
                }
            }
        });
    }

    private void updatePatient() {
        this.view.getPatientPanel().getPnSubPatient().getBtnSave().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = view.getPatientPanel().getPnSubPatient().getTfId().getText();
                if (patientModel.findPatientById(id) != null) {
                    String name = view.getPatientPanel().getPnSubPatient().getTfName().getText();
                    String address = view.getPatientPanel().getPnSubPatient().getTfAddress().getText();
                    String phone = view.getPatientPanel().getPnSubPatient().getTfPhone().getText();
                    int yearOfBirth = Integer
                            .parseInt(view.getPatientPanel().getPnSubPatient().getTfYearOfBirth().getText());
                    String gender = view.getPatientPanel().getPnSubPatient().getCbbGender().getSelectedItem() + "";

                    Patient patient = new Patient(id, name, address, phone, yearOfBirth, true);
                    if (gender.equalsIgnoreCase("Nữ"))
                        patient = new Patient(id, name, address, phone, yearOfBirth, false);

                    if (patientModel.updatePatient(patient))
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
        this.view.getPatientPanel().getPnSubPatient().getBtnRemove().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "Bạn có chắc là xóa bệnh nhân này", "Xác nhận",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.YES_OPTION) {
                    String id = view.getPatientPanel().getPnSubPatient().getTfId().getText();
                    if (patientModel.deletePatient(id))
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
        this.view.getPatientPanel().getPnSubPatient().getTfSearch().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String charName = view.getPatientPanel().getPnSubPatient().getTfSearch().getText();
                List<Patient> patients = PatientDAO.findAllByCharName(charName);
                view.getPatientPanel().getPnSubPatient().getDtmPatient().setRowCount(0);
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
                    view.getPatientPanel().getPnSubPatient().getDtmPatient().addRow(vec);
                }
            }
        });
    }

    private void resetForm() {
        view.getPatientPanel().getPnSubPatient().getTfId().setText("");
        view.getPatientPanel().getPnSubPatient().getTfName().setText("");
        view.getPatientPanel().getPnSubPatient().getTfPhone().setText("");
        view.getPatientPanel().getPnSubPatient().getTfYearOfBirth().setText("");
        view.getPatientPanel().getPnSubPatient().getTfAddress().setText("");
    }

}
