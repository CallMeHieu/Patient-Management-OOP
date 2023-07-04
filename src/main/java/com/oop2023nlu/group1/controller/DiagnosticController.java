package com.oop2023nlu.group1.controller;

import com.oop2023nlu.group1.model.Patient;
import com.oop2023nlu.group1.model.Visit;
import com.oop2023nlu.group1.view.container.Container;
import com.oop2023nlu.group1.view.panel.sub.PnItemDiagnostic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;


public class DiagnosticController {
    private Container view;
    private Patient patientModel;
    private final PnItemDiagnostic pnItemDiagnostic;

    public DiagnosticController(Container view, Patient patientModel) {
        super();
        this.view = view;
        this.patientModel = patientModel;
        this.pnItemDiagnostic = this.view.getPatientPanel().getPnItemDiagnostic();
        initViewListeners();
    }

    private void initViewListeners() {
        backToScreenPatient();
        nextToScreenPrescriptions();
    }

    private void nextToScreenPrescriptions() {
        pnItemDiagnostic.getBtnContinue().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (pnItemDiagnostic.getTaSymptom().getText().equals("")
                        || pnItemDiagnostic.getTaConclusion().getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin !!!");
                    return;
                }
                view.changeScreen("3");

                String symptom = pnItemDiagnostic.getTaSymptom().getText();
                String conclusion = pnItemDiagnostic.getTaConclusion().getText();
                Visit visit = new Visit("", new Date(), symptom, conclusion, null);
                view.getPatientPanel().getPnItemPrescriptions().resetForm();
                view.getPatientPanel().getPnItemPrescriptions().loadInfo(getPatientModel(), visit);
            }
        });
    }

    private void backToScreenPatient() {
        pnItemDiagnostic.getBtnBack().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.changeScreen("1");
            }
        });
    }

    private Patient getPatientModel() {
        String id = pnItemDiagnostic.getTfId().getText();
        String name = pnItemDiagnostic.getTfName().getText();
        String address = pnItemDiagnostic.getTfAddress().getText();
        String phone = pnItemDiagnostic.getTfPhone().getText();
        String gender = pnItemDiagnostic.getTfGender().getText();
        int yearOfBirth = Integer.parseInt(pnItemDiagnostic.getTfBirthDay().getText());
        if (gender.equalsIgnoreCase("Nữ"))
            return new Patient(id, name, address, phone, yearOfBirth, false);
        return new Patient(id, name, address, phone, yearOfBirth, true);
    }
}
