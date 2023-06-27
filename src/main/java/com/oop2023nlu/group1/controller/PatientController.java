package com.oop2023nlu.group1.controller;

import com.oop2023nlu.group1.dao.PatientDAO;
import com.oop2023nlu.group1.model.*;
import com.oop2023nlu.group1.view.container.Container;
import com.oop2023nlu.group1.view.panel.sub.PnItemInfoPatient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

public class PatientController {
    private Container view;
    private Patient patientModel;
    private final PnItemInfoPatient pnItemInfoPatient;

    public PatientController(Container view, Patient patientModel) {
        this.view = view;
        this.patientModel = patientModel;
        this.pnItemInfoPatient = view.getPatientPanel().getPnItemInfoPatient();
        this.patientModel.registerObserver(pnItemInfoPatient);
        this.view.getPatientPanel().getPnItemInfoPatient().setModel(patientModel);
        this.patientModel.notifyObservers();
        initViewListeners();
    }

    private void initViewListeners() {
        add();
        update();
        delete();
        diagnose();
        search();
    }

    private void add() {
        pnItemInfoPatient.getBtnAdd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pnItemInfoPatient.getTfId().getText().equals("")) {
                    String id;
                    if (patientModel.getPatients() == null) {
                        id = "BN1";
                    } else id = "BN" + (patientModel.getPatients().size() + 1);
                    Patient patient = getPatientModel();
                    patient.setId(id);
                    ArrayList<Visit> visits = new ArrayList<>();
                    patient.setVisits(visits);
                    patientModel.addPatient(patient);
                    pnItemInfoPatient.resetForm();
                    JOptionPane.showMessageDialog(null, "Thêm thành công");
                } else {
                    pnItemInfoPatient.resetForm();
                }
            }
        });
    }

    private void update() {
        pnItemInfoPatient.getBtnSave().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (patientModel.findPatientById(pnItemInfoPatient.getTfId().getText()) != null) {
                    if (patientModel.updatePatient(getPatientModel()))
                        JOptionPane.showMessageDialog(null, "Cập nhật thành công");
                    else JOptionPane.showMessageDialog(null, "Cập nhật thất bại!!!");
                } else {
                    JOptionPane.showMessageDialog(null, "Lỗi !!! Không tìm thấy bệnh nhân này");
                }
            }
        });
    }

    private void delete() {
        pnItemInfoPatient.getBtnRemove().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "Bạn có chắc là xóa bệnh nhân này", "Xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.YES_OPTION) {
                    String id = pnItemInfoPatient.getTfId().getText();
                    if (patientModel.deletePatient(id)) JOptionPane.showMessageDialog(null, "Xóa thành công");
                    else JOptionPane.showMessageDialog(null, "Xóa thất bại!!!");
                } else if (result == JOptionPane.NO_OPTION) {
                    System.out.println("Bạn chọn không");
                } else {
                    System.out.println("...");
                }
            }
        });
    }

    private void diagnose() {
        pnItemInfoPatient.getBtnDiagnostic().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pnItemInfoPatient.getTfId().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn bệnh nhân");
                    return;
                }
                view.changeScreen("2");
                String id = pnItemInfoPatient.getTfId().getText();
                Patient patient = patientModel.findPatientById(id);
                view.getPatientPanel().getPnItemDiagnostic().resetForm();
                view.getPatientPanel().getPnItemDiagnostic().loadPatient(patient);
            }
        });
    }

    private void search() {
        pnItemInfoPatient.getTfSearch().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String charName = pnItemInfoPatient.getTfSearch().getText();
                List<Patient> patients = PatientDAO.findAllByCharName(charName);
                pnItemInfoPatient.getDtmPatient().setRowCount(0);
                for (Patient patient : patients) {
                    Vector<Object> vec = new Vector<Object>();
                    vec.add(patient.getId());
                    vec.add(patient.getName());
                    vec.add(patient.getYearOfBirth());
                    if (patient.isGender()) {
                        vec.add("Nam");
                    } else vec.add("Nữ");
                    vec.add(patient.getPhone());
                    vec.add(patient.getAddress());
                    pnItemInfoPatient.getDtmPatient().addRow(vec);
                }
            }
        });
    }
    private Patient getPatientModel() {
        String id = pnItemInfoPatient.getTfId().getText();
        String name = pnItemInfoPatient.getTfName().getText();
        String address = pnItemInfoPatient.getTfAddress().getText();
        String phone = pnItemInfoPatient.getTfPhone().getText();
        String gender = pnItemInfoPatient.getCbbGender().getSelectedItem() + "";
        int yearOfBirth = Integer.parseInt(pnItemInfoPatient.getTfYearOfBirth().getText());
        if (gender.equalsIgnoreCase("Nữ"))
            return new Patient(id, name, address, phone, yearOfBirth, false);
        return new Patient(id, name, address, phone, yearOfBirth, true);
    }

}
