package com.oop2023nlu.group1.controller;

import com.oop2023nlu.group1.model.Clinic;
import com.oop2023nlu.group1.model.Patient;
import com.oop2023nlu.group1.model.PrescriptionMedicine;
import com.oop2023nlu.group1.model.Visit;
import com.oop2023nlu.group1.utils.ModelUtils;
import com.oop2023nlu.group1.view.container.Container;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.JOptionPane;


public class DiagnosticController {
    private Container view;
    private Clinic model;

    public DiagnosticController(Container view, Clinic model) {
        super();
        this.view = view;
        this.model = model;
        initViewListeners();
    }

    private void initViewListeners() {
        loadDataOfTableDiagnostic();
        backToScreenPatient();
        nextToScreenPrescriptions();
    }

    private void nextToScreenPrescriptions() {
        view.getPatientPanel().getPnSubChuanHoa().getBtnContinue().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getPatientPanel().getPnSubChuanHoa().getTaSymptom().getText().equals("")
                        || view.getPatientPanel().getPnSubChuanHoa().getTaCnclude().getText().equals(""))
                    return;
                view.getPatientPanel().getCardPanelGroup().show(view.getPatientPanel().getPnCard(), "3");
                view.getPatientPanel().getLbCard3().setBackground(new Color(240, 240, 240));
                view.getPatientPanel().getLbCard3().setFont(new Font("Tahoma", Font.PLAIN, 16));
                view.getPatientPanel().getLbCard2().setBackground(Color.WHITE);
                view.getPatientPanel().getLbCard2().setFont(view.getPatientPanel().fontMenu);
                view.getPatientPanel().getLbCard1().setBackground(Color.WHITE);
                view.getPatientPanel().getLbCard1().setFont(view.getPatientPanel().fontMenu);
                String id = view.getPatientPanel().getPnSubChuanHoa().getTfId().getText();
                String name = view.getPatientPanel().getPnSubChuanHoa().getTfName().getText();
                String address = view.getPatientPanel().getPnSubChuanHoa().getTfAddress().getText();
                String phone = view.getPatientPanel().getPnSubChuanHoa().getTfPhone().getText();
                int yearOfBirth = Integer.parseInt(view.getPatientPanel().getPnSubChuanHoa().getTfBirthDay().getText());
                String symptom = view.getPatientPanel().getPnSubChuanHoa().getTaSymptom().getText();
                ;
                String conclusion = view.getPatientPanel().getPnSubChuanHoa().getTaCnclude().getText();
                ;
                Patient patient = new Patient(id, name, address, phone, yearOfBirth, false);
                Visit visit = new Visit("", new Date(), symptom, conclusion, null);
                view.getPatientPanel().getPnItemPrescriptions().loadInfo(patient, visit);
            }
        });
    }

    private void backToScreenPatient() {
        view.getPatientPanel().getPnSubChuanHoa().getBtnBack().addActionListener(new ActionListener() {
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
        view.getPatientPanel().getPnSubBenhNhan().getBtnView().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getPatientPanel().getPnSubBenhNhan().getTfId().getText().isEmpty()) {
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
                String id = view.getPatientPanel().getPnSubBenhNhan().getTfId().getText();
                Patient patient = model.findPatientById(id);
                view.getPatientPanel().getPnSubChuanHoa().loadPatient(patient);
            }
        });
    }
}
