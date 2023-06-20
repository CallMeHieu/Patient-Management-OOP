package com.oop2023nlu.group1.controller;

import com.oop2023nlu.group1.model.Patient;
import com.oop2023nlu.group1.model.Visit;
import com.oop2023nlu.group1.view.container.Container;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;


public class DiagnosticController {
    private Container view;
    private Patient patientModel;

    public DiagnosticController(Container view, Patient patientModel) {
        super();
        this.view = view;
        this.patientModel = patientModel;
        initViewListeners();
    }

    private void initViewListeners() {
        loadDataOfTableDiagnostic();
        backToScreenPatient();
        nextToScreenPrescriptions();
    }

    private void nextToScreenPrescriptions() {
        view.getPatientPanel().getPnItemDiagnostic().getBtnContinue().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getPatientPanel().getPnItemDiagnostic().getTaSymptom().getText().equals("")
                        || view.getPatientPanel().getPnItemDiagnostic().getTaCnclude().getText().equals(""))
                    return;
                view.getPatientPanel().getCardPanelGroup().show(view.getPatientPanel().getPnCard(), "3");
                view.getPatientPanel().getLbCard3().setBackground(new Color(240, 240, 240));
                view.getPatientPanel().getLbCard3().setFont(new Font("Tahoma", Font.PLAIN, 16));
                view.getPatientPanel().getLbCard2().setBackground(Color.WHITE);
                view.getPatientPanel().getLbCard2().setFont(view.getPatientPanel().fontMenu);
                view.getPatientPanel().getLbCard1().setBackground(Color.WHITE);
                view.getPatientPanel().getLbCard1().setFont(view.getPatientPanel().fontMenu);
                String id = view.getPatientPanel().getPnItemDiagnostic().getTfId().getText();
                String name = view.getPatientPanel().getPnItemDiagnostic().getTfName().getText();
                String address = view.getPatientPanel().getPnItemDiagnostic().getTfAddress().getText();
                String phone = view.getPatientPanel().getPnItemDiagnostic().getTfPhone().getText();
                int yearOfBirth = Integer.parseInt(view.getPatientPanel().getPnItemDiagnostic().getTfBirthDay().getText());
                String symptom = view.getPatientPanel().getPnItemDiagnostic().getTaSymptom().getText();
                String conclusion = view.getPatientPanel().getPnItemDiagnostic().getTaCnclude().getText();
                Patient patient = new Patient(id, name, address, phone, yearOfBirth, false);
                Visit visit = new Visit("", new Date(), symptom, conclusion, null);
                view.getPatientPanel().getPnItemPrescriptions().loadInfo(patient, visit);
            }
        });
    }

    private void backToScreenPatient() {
        view.getPatientPanel().getPnItemDiagnostic().getBtnBack().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getPatientPanel().getCardPanelGroup().show(view.getPatientPanel().getPnCard(), "1");
                view.getPatientPanel().getLbCard1().setBackground(new Color(240, 240, 240));
                view.getPatientPanel().getLbCard1().setFont(new Font("Tahoma", Font.PLAIN, 16));
                view.getPatientPanel().getLbCard2().setBackground(Color.WHITE);
                view.getPatientPanel().getLbCard2().setFont(view.getPatientPanel().fontMenu);
                view.getPatientPanel().getLbCard3().setBackground(Color.WHITE);
                view.getPatientPanel().getLbCard3().setFont(view.getPatientPanel().fontMenu);
            }
        });
    }

    private void loadDataOfTableDiagnostic() {
        view.getPatientPanel().getPnSubPatient().getBtnView().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getPatientPanel().getPnSubPatient().getTfId().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn bệnh nhân");
                    return;
                }
                view.getPatientPanel().getCardPanelGroup().show(view.getPatientPanel().getPnCard(), "2");
                view.getPatientPanel().getLbCard2().setBackground(new Color(240, 240, 240));
                view.getPatientPanel().getLbCard2().setFont(new Font("Tahoma", Font.PLAIN, 16));
                view.getPatientPanel().getLbCard1().setBackground(Color.WHITE);
                view.getPatientPanel().getLbCard1().setFont(view.getPatientPanel().fontMenu);
                view.getPatientPanel().getLbCard3().setBackground(Color.WHITE);
                view.getPatientPanel().getLbCard3().setFont(view.getPatientPanel().fontMenu);
                String id = view.getPatientPanel().getPnSubPatient().getTfId().getText();
                Patient patient = patientModel.findPatientById(id);
                view.getPatientPanel().getPnItemDiagnostic().loadPatient(patient);
            }
        });
    }
}
